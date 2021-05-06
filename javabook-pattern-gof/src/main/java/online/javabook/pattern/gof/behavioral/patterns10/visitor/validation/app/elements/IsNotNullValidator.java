package online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.elements;

import java.lang.annotation.Annotation;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.annotations.IsNotNull;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

public class IsNotNullValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = propertyValue != null;

        IsNotNull isNotEmptyAnnotation = (IsNotNull) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isNotEmptyAnnotation.error(), isNotEmptyAnnotation.code());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.visit(this, attribute, propertyName, propertyValue);
    }
}
