package org.gof.behavioral.patterns1.intercepting.httpfilter;

import org.apache.http.HttpRequest;

public class HttpRbacFilter implements IHttpFilter {
    @Override
    public void execute(HttpRequest request) {
        System.out.println("check rbac");
    }
}
