package online.javabook.gof.behavioral.patterns2.command2.restful.register;

import online.javabook.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;
import online.javabook.gof.behavioral.patterns2.command2.restful.commands.RestfulInstance;
import online.javabook.gof.behavioral.patterns2.command2.restful.commands.RestfulAnnotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RestfulRegister {

    private Map<String, RestfulInstance> restfulApiHashMap = new HashMap<>();

    public void register(Class controllerClass) throws IllegalAccessException, InstantiationException {
        Object controller = controllerClass.newInstance();
        Method[] methods = controllerClass.getMethods();

        for (Method method : methods) {
            RestfulAnnotation annotation = method.getAnnotation(RestfulAnnotation.class);
            if(annotation!= null) {
                String restfulApiPath = annotation.path() + ":" + annotation.httpMethod();
                RestfulInstance restfulApi = new RestfulInstance(controller, method);
                restfulApiHashMap.put(restfulApiPath, restfulApi);
            }
        }
    }

    private RestfulInstance discover(String path, HttpMethod httpMethod) {
        String restfulApiPath = path + ":" + httpMethod;
        return restfulApiHashMap.get(restfulApiPath);
    }

    public void doRestful(String path, HttpMethod httpMethod, HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        discover(path, httpMethod).execute(request, response);
    }
}
