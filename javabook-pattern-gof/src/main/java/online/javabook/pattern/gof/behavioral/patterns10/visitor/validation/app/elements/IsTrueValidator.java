package online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.elements;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.annotations.IsTrue;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.IValidatorAccept;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor.ValidatorVisitor;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class IsTrueValidator implements IValidator, IValidatorAccept {
    @Override
    public ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue) {
        boolean isValid = Boolean.parseBoolean(propertyValue.toString());

        IsTrue isTrueAnnotation = (IsTrue) annotation;
        return isValid?
                new ValidatorResponse(true, propertyName, propertyValue) :
                new ValidatorResponse(false, propertyName, propertyValue, isTrueAnnotation.error(), isTrueAnnotation.code());
    }

    @Override
    public ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue) {
        return validatorVisitor.Visit(this, attribute, propertyName, propertyValue);
    }
}
