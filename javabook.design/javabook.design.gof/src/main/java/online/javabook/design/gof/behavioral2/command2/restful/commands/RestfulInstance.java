package online.javabook.design.gof.behavioral2.command2.restful.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RestfulInstance {
    private Object controller;
    private Method method;

    public RestfulInstance(Object controller, Method method) {
        this.controller = controller;
        this.method = method;
    }

    public void execute(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        method.invoke(controller, request, response);
    }
}
