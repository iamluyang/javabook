package org.gof.behavioral.patterns11.intercepting.httpfilter;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;

import java.io.IOException;

public interface IHttpRequestInterceptor {
    void execute(HttpRequest request) throws HttpException, IOException;
}
