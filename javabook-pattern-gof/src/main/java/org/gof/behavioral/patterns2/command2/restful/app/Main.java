package org.gof.behavioral.patterns2.command2.restful.app;

import org.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import org.gof.behavioral.patterns2.command2.restful.controller.GroupController;
import org.gof.behavioral.patterns2.command2.restful.controller.UserController;
import org.gof.behavioral.patterns2.command2.restful.register.RestfulRegister;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        RestfulRegister restfulRegister = new RestfulRegister();
        restfulRegister.register(UserController.class);
        restfulRegister.register(GroupController.class);

        restfulRegister.doRestfulApi("/api/users", HttpMethod.POST);
        restfulRegister.doRestfulApi("/api/users", HttpMethod.GET);
        restfulRegister.doRestfulApi("/api/users", HttpMethod.PUT);
        restfulRegister.doRestfulApi("/api/users", HttpMethod.DELETE);

        restfulRegister.doRestfulApi("/api/groups", HttpMethod.POST);
        restfulRegister.doRestfulApi("/api/groups", HttpMethod.GET);
        restfulRegister.doRestfulApi("/api/groups", HttpMethod.PUT);
        restfulRegister.doRestfulApi("/api/groups", HttpMethod.DELETE);
    }
}
