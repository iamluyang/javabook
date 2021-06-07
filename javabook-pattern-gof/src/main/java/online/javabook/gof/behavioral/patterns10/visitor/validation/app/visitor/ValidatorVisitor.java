package online.javabook.gof.behavioral.patterns10.visitor.validation.app.visitor;

import online.javabook.gof.behavioral.patterns10.visitor.validation.app.elements.*;
import online.javabook.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public class ValidatorVisitor {

    public ValidatorResponse visit(IsNotNullValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse visit(IsNotEmptyValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse visit(IsTrueValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse visit(IsFalseValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

    public ValidatorResponse visit(IsNumberValidator validator, Annotation annotation, String propertyName, Object propertyValue) {
        return validator.isVerify(annotation, propertyName, propertyValue);
    }

}
