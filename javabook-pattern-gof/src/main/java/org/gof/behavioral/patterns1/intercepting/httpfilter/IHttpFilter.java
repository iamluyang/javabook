package org.gof.behavioral.patterns1.intercepting.httpfilter;

import org.apache.http.HttpRequest;

public interface IHttpFilter {
    public void execute(HttpRequest request) throws Exception;
}
