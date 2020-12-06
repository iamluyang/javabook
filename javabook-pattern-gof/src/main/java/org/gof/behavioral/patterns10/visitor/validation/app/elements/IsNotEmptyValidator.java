package org.gof.behavioral.patterns10.visitor.validation.app.elements;

import org.gof.behavioral.patterns10.visitor.validation.app.annotations.IsNotEmpty;
import org.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import org.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import org.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsNotEmptyValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = propertyValue != null && !propertyValue.toString().equals("");

        IsNotEmpty isNotEmptyAnnotation = (IsNotEmpty) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isNotEmptyAnnotation.error(), isNotEmptyAnnotation.code());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.Visit(this, attribute, propertyName, propertyValue);
    }
}
