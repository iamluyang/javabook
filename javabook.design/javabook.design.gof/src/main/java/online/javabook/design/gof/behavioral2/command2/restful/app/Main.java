package online.javabook.design.gof.behavioral2.command2.restful.app;

import online.javabook.design.gof.behavioral2.command2.restful.controller.GroupController;
import online.javabook.design.gof.behavioral2.command2.restful.controller.UserController;
import online.javabook.design.gof.behavioral2.command2.restful.register.RestfulRegister;
import online.javabook.design.gof.behavioral2.command2.restful.commands.HttpMethod;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        RestfulRegister restfulRegister = new RestfulRegister();
        restfulRegister.register(UserController.class);
        restfulRegister.register(GroupController.class);

        HttpServletRequest  mockedRequest = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse  mockedResponse = Mockito.mock(HttpServletResponse.class);
        restfulRegister.doRestful("/api/users", HttpMethod.POST, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/users", HttpMethod.GET, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/users", HttpMethod.PUT, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/users", HttpMethod.DELETE, mockedRequest, mockedResponse);

        restfulRegister.doRestful("/api/groups", HttpMethod.POST, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/groups", HttpMethod.GET, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/groups", HttpMethod.PUT, mockedRequest, mockedResponse);
        restfulRegister.doRestful("/api/groups", HttpMethod.DELETE, mockedRequest, mockedResponse);
    }
}
