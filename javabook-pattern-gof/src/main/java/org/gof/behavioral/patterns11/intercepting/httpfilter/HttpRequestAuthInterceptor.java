package org.gof.behavioral.patterns11.intercepting.httpfilter;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;

public class HttpRequestAuthInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpRequest request) throws HttpException {
        String hasAuthorization = request.getFirstHeader("Authorization").getValue();
        if (StringUtils.isAllEmpty(hasAuthorization)) {
            throw new HttpException("Authorization is Null");
        }
    }
}
