package org.gof.behavioral.patterns10.visitor.validation.app.annotations;

import org.gof.behavioral.patterns10.visitor.validation.other.HttpStatusCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNumber {

    public int min() default 0;

    public int max() default 0;

    public String error() default "";

    public HttpStatusCode code() default HttpStatusCode.BadRequest;

}
