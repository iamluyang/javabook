package org.gof.behavioral.patterns2.command2.restful.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RestfulApiAnnotation {
    public String path();

    public HttpMethod httpMethod();
}
