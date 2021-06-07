package online.javabook.gof.behavioral.patterns2.command2.restful.controller;

import online.javabook.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import online.javabook.gof.behavioral.patterns2.command2.restful.commands.RestfulAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GroupController {

    @RestfulAnnotation(path = "/api/groups", httpMethod = HttpMethod.POST)
    public void createUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("create group");
    }

    @RestfulAnnotation(path = "/api/groups", httpMethod = HttpMethod.GET)
    public void readUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("read group");
    }

    @RestfulAnnotation(path = "/api/groups", httpMethod = HttpMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update group");
    }

    @RestfulAnnotation(path = "/api/groups", httpMethod = HttpMethod.DELETE)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete group");
    }
}
