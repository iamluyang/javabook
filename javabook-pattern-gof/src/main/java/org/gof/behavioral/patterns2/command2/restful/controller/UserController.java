package org.gof.behavioral.patterns2.command2.restful.controller;

import org.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import org.gof.behavioral.patterns2.command2.restful.commands.HttpRequest;
import org.gof.behavioral.patterns2.command2.restful.commands.RestfulApiAnnotation;

public class UserController {

    @RestfulApiAnnotation(path = "/api/users", httpMethod = HttpMethod.POST)
    public void createUser(HttpRequest httpRequest) {
        System.out.println("create user");
    }

    @RestfulApiAnnotation(path = "/api/users", httpMethod = HttpMethod.GET)
    public void readUser(HttpRequest httpRequest) {
        System.out.println("read user");
    }

    @RestfulApiAnnotation(path = "/api/users", httpMethod = HttpMethod.PUT)
    public void updateUser(HttpRequest httpRequest) {
        System.out.println("update user");
    }

    @RestfulApiAnnotation(path = "/api/users", httpMethod = HttpMethod.DELETE)
    public void deleteUser(HttpRequest httpRequest) {
        System.out.println("delete user");
    }
}
