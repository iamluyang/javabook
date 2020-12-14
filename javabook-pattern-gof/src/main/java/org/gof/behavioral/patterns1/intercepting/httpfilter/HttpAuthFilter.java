package org.gof.behavioral.patterns1.intercepting.httpfilter;

import org.apache.http.HttpRequest;

public class HttpAuthFilter implements IHttpFilter {
    @Override
    public void execute(HttpRequest request) throws Exception {

        if (request.getHeaders("Authorization") == null) {
            throw new Exception("Authorization is Null");
        }
    }
}
