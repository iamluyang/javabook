package org.gof.behavioral.patterns2.command2.restful.controller;

import org.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import org.gof.behavioral.patterns2.command2.restful.commands.HttpRequest;
import org.gof.behavioral.patterns2.command2.restful.commands.RestfulApiAnnotation;

public class GroupController {

    @RestfulApiAnnotation(path = "/api/groups", httpMethod = HttpMethod.POST)
    public void createUser(HttpRequest httpRequest) {
        System.out.println("create group");
    }

    @RestfulApiAnnotation(path = "/api/groups", httpMethod = HttpMethod.GET)
    public void readUser(HttpRequest httpRequest) {
        System.out.println("read group");
    }

    @RestfulApiAnnotation(path = "/api/groups", httpMethod = HttpMethod.PUT)
    public void updateUser(HttpRequest httpRequest) {
        System.out.println("update group");
    }

    @RestfulApiAnnotation(path = "/api/groups", httpMethod = HttpMethod.DELETE)
    public void deleteUser(HttpRequest httpRequest) {
        System.out.println("delete group");
    }
}
