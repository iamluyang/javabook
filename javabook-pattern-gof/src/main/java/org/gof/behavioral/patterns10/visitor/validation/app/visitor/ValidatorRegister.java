package org.gof.behavioral.patterns10.visitor.validation.app.visitor;

import org.gof.behavioral.patterns10.visitor.validation.app.annotations.*;
import org.gof.behavioral.patterns10.visitor.validation.app.elements.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ValidatorRegister {

    public ValidatorRegister() {
        registerValidator(IsFalse.class, new IsFalseValidator());
        registerValidator(IsTrue.class, new IsTrueValidator());
        registerValidator(IsNotEmpty.class, new IsNotEmptyValidator());
        registerValidator(IsNotNull.class, new IsNotNullValidator());
        registerValidator(IsEmail.class, new IsEmailValidator());
        registerValidator(IsInetAddress.class, new IsInetAddressValidator());
        registerValidator(IsNumber.class, new IsNumberValidator());
    }

    private static Map<Class<? extends Annotation>, IValidator> validatorMap = new HashMap<>();

    public static void registerValidator(Class<? extends Annotation> annotation, IValidator validator) {
        validatorMap.put(annotation, validator);
    }

    public static IValidator getValidator(Class<? extends Annotation> annotation) {
        return validatorMap.get(annotation);
    }
}
