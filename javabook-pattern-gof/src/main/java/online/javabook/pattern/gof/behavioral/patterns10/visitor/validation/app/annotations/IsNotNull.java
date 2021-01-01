package online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.app.annotations;

import online.javabook.pattern.gof.behavioral.patterns10.visitor.validation.other.HttpStatusCode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsNotNull {

    public String error() default "";

    public HttpStatusCode code() default HttpStatusCode.BadRequest;
}
