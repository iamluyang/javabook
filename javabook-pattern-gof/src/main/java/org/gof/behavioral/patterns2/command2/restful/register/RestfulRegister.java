package org.gof.behavioral.patterns2.command2.restful.register;

import org.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import org.gof.behavioral.patterns2.command2.restful.commands.HttpRequest;
import org.gof.behavioral.patterns2.command2.restful.commands.RestfulApi;
import org.gof.behavioral.patterns2.command2.restful.commands.RestfulApiAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RestfulRegister {

    private Map<String, RestfulApi> restfulApiHashMap = new HashMap<>();

    public void register(Class controllerClass) throws IllegalAccessException, InstantiationException {
        Object controller = controllerClass.newInstance();
        Method[] methods = controllerClass.getMethods();

        for (Method method : methods) {
            RestfulApiAnnotation annotation = method.getAnnotation(RestfulApiAnnotation.class);
            if(annotation!= null) {
                String restfulApiPath = annotation.path() + ":" + annotation.httpMethod();
                RestfulApi restfulApi = new RestfulApi(controller, method);
                restfulApiHashMap.put(restfulApiPath, restfulApi);
            }
        }
    }

    private RestfulApi discover(String path, HttpMethod httpMethod) {
        String restfulApiPath = path + ":" + httpMethod;
        return restfulApiHashMap.get(restfulApiPath);
    }

    public void doRestfulApi(String path, HttpMethod httpMethod) throws InvocationTargetException, IllegalAccessException {
        discover(path, httpMethod).execute(new HttpRequest());
    }
}
