package online.javabook.pattern.gof.behavioral.patterns2.command2.restful.controller;

import online.javabook.pattern.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import online.javabook.pattern.gof.behavioral.patterns2.command2.restful.commands.HttpRequest;
import online.javabook.pattern.gof.behavioral.patterns2.command2.restful.register.RestfulApiAnnotation;

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
