package online.javabook.design.gof.behavioral10.visitor.validation.app.elements;

import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public interface IValidator {
    ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue);
}
