package org.gof.behavioral.patterns2.command2.restful.commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RestfulApi {
    private Object controller;
    private Method method;

    public RestfulApi(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public void execute(HttpRequest httpRequest) throws InvocationTargetException, IllegalAccessException {
        method.invoke(controller, httpRequest);
    }
}
