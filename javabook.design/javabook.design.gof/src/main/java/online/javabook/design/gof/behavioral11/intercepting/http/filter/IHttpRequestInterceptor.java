package online.javabook.design.gof.behavioral11.intercepting.http.filter;

import javax.servlet.http.HttpServletRequest;

public interface IHttpRequestInterceptor {
    void execute(HttpServletRequest request) throws Exception;
}
