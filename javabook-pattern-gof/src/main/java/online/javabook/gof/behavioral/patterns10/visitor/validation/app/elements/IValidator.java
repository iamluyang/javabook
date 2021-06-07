package online.javabook.gof.behavioral.patterns10.visitor.validation.app.elements;

import online.javabook.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public interface IValidator {
    ValidatorResponse isVerify(Annotation annotation, String propertyName, Object propertyValue);
}
