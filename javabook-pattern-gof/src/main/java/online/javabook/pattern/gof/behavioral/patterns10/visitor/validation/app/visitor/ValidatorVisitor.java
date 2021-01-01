package online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.visitor;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.elements.*;
import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class ValidatorVisitor {

    public ValidatorResponse Visit(IsNotNullValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsNotEmptyValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsTrueValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsFalseValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsEmailValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsInetAddressValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse Visit(IsNumberValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

}
