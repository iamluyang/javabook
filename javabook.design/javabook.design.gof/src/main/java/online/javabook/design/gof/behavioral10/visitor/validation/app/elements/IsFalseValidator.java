package online.javabook.design.gof.behavioral10.visitor.validation.app.elements;

import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.IsFalse;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.design.gof.behavioral10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsFalseValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = !Boolean.parseBoolean(propertyValue.toString());

        IsFalse isFalseAnnotation = (IsFalse) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isFalseAnnotation.error());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.visit(this, attribute, propertyName, propertyValue);
    }
}
