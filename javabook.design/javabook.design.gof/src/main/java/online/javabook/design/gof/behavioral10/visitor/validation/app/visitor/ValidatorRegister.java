package online.javabook.design.gof.behavioral10.visitor.validation.app.visitor;

import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.*;
import online.javabook.design.gof.behavioral10.visitor.validation.app.elements.*;
import online.javabook.design.gof.behavioral10.visitor.validation.app.annotations.*;
import online.javabook.design.gof.behavioral10.visitor.validation.app.elements.*;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

public class ValidatorRegister {

    private static Map<Class<? extends Annotation>, IValidator> validatorMap = new HashMap<>();

    static  {
        registerValidator(IsFalse.class, new IsFalseValidator());
        registerValidator(IsTrue.class, new IsTrueValidator());
        registerValidator(IsNotEmpty.class, new IsNotEmptyValidator());
        registerValidator(IsNotNull.class, new IsNotNullValidator());
        registerValidator(IsNumber.class, new IsNumberValidator());
    }

    public static void registerValidator(Class<? extends Annotation> annotation, IValidator validator) {
        validatorMap.put(annotation, validator);
    }

    public static IValidator getValidator(Class<? extends Annotation> annotation) {
        return validatorMap.get(annotation);
    }
}
