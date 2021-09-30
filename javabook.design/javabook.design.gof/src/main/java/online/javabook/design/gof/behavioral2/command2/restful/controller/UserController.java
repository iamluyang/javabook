package online.javabook.design.gof.behavioral2.command2.restful.controller;

import online.javabook.design.gof.behavioral2.command2.restful.commands.HttpMethod;
import online.javabook.design.gof.behavioral2.command2.restful.commands.RestfulAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {

    @RestfulAnnotation(path = "/api/users", httpMethod = HttpMethod.POST)
    public void createUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("create user");
    }

    @RestfulAnnotation(path = "/api/users", httpMethod = HttpMethod.GET)
    public void readUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("read user");
    }

    @RestfulAnnotation(path = "/api/users", httpMethod = HttpMethod.PUT)
    public void updateUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("update user");
    }

    @RestfulAnnotation(path = "/api/users", httpMethod = HttpMethod.DELETE)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("delete user");
    }
}
