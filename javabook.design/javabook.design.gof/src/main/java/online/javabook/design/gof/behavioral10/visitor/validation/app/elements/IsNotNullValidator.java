package online.javabook.design.gof.behavioral10.visitor.validation.app.elements;

import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsNotNull;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsNotNullValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = propertyValue != null;

        IsNotNull isNotNullAnnotation = (IsNotNull) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isNotNullAnnotation.error());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.visit(this, attribute, propertyName, propertyValue);
    }
}
