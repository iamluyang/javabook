package org.gof.behavioral.patterns11.intercepting.http.filter;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;

public class HttpRequestRbacInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpRequest request) throws HttpException {
        System.out.println("check rbac OK");
    }
}
