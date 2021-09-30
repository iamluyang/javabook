package online.javabook.design.gof.behavioral11.intercepting.http.filter;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestAuthInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpServletRequest request) throws Exception {
        String hasAuthorization = request.getHeader("Authorization");
        if (hasAuthorization == null) {
            throw new Exception("Authorization is Null");
        }
    }
}
