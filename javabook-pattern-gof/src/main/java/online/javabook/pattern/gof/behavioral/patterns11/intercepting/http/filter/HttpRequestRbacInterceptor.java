package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestRbacInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpServletRequest request) throws Exception {
        System.out.println("check rbac OK");
    }
}
