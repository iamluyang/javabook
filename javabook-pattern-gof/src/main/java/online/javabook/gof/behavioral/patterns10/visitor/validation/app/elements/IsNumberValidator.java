package online.javabook.gof.behavioral.patterns10.visitor.validation.app.elements;

import online.javabook.gof.behavioral.patterns10.visitor.validation.app.annotations.IsNumber;
import online.javabook.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsNumberValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        IsNumber isNumberAnnotation = (IsNumber) annotation;

        int number = Integer.parseInt(propertyValue.toString());
        boolean isValid = (isNumberAnnotation.min() <= number) && (number <= isNumberAnnotation.max());
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isNumberAnnotation.error());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.visit(this, attribute, propertyName, propertyValue);
    }
}
