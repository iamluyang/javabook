package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;

public class HttpRequestAuthInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpRequest request) throws HttpException {
        String hasAuthorization = request.getFirstHeader("Authorization").getValue();
        if (StringUtils.isEmpty(hasAuthorization)) {
            throw new HttpException("Authorization is Null");
        }
    }
}
