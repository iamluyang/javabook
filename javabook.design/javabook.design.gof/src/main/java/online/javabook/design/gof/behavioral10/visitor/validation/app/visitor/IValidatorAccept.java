package online.javabook.design.gof.behavioral10.visitor.validation.app.visitor;

import online.javabook.design.gof.behavioral10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public interface IValidatorAccept {

    ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue);
}
