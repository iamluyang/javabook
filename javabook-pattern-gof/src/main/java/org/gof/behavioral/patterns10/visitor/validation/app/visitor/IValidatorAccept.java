package org.gof.behavioral.patterns10.visitor.validation.app.visitor;

import org.gof.behavioral.patterns10.visitor.validation.other.ValidatorResponse;

import java.lang.annotation.Annotation;

public interface IValidatorAccept {

    ValidatorResponse Accept(ValidatorVisitor validatorVisitor, Annotation attribute, String propertyName, Object propertyValue);
}
