package online.javabook.design.gof.behavioral10.visitor.validation.app;

import online.javabook.design.gof.behavioral10.visitor.validation.app.elements.IValidator;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.ValidatorRegister;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidatorUtils {

    private ValidatorVisitor visitor = new ValidatorVisitor();

    public List<ValidatorResponse> validate(Object value) throws IllegalAccessException {

        List<ValidatorResponse> validatorResponses = new ArrayList();

        Field[] fields = value.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            String propertyName = field.getName();
            Object propertyValue = field.get(value);

            Annotation[] propertyAnnotations = field.getAnnotations();

            for (Annotation propertyAnnotation: propertyAnnotations) {
                IValidator validator = ValidatorRegister.getValidator(propertyAnnotation.annotationType());
                if(validator!=null) {

                    // validator is accept
                    IValidatorAccept accept = (IValidatorAccept)validator;

                    // accept
                    ValidatorResponse validatorResponse = accept.Accept(visitor, propertyAnnotation, propertyName, propertyValue);

                    // response
                    if(!validatorResponse.isValid()) {
                        validatorResponses.add(validatorResponse);
                    }
                }
            }
        }

        return validatorResponses;
    }
}
