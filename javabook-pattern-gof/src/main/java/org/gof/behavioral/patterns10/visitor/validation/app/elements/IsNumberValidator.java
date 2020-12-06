package org.gof.behavioral.patterns10.visitor.validation.app.elements;

import org.gof.behavioral.patterns10.visitor.validation.app.annotations.IsNumber;
import org.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import org.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import org.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsNumberValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        IsNumber isNumber = (IsNumber) annotation;

        int number = Integer.parseInt(propertyValue.toString());
        boolean isValid = (isNumber.min() <= number) && (number <= isNumber.max());
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isNumber.error(), isNumber.code());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.Visit(this, attribute, propertyName, propertyValue);
    }
}