package org.gof.behavioral.patterns11.intercepting.httpfilter;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;

import java.io.IOException;
import java.util.Calendar;

public class HttpRequestTimeInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpRequest request) throws HttpException, IOException {
        Calendar c = Calendar.getInstance();

        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            throw new HttpException("非工作日");
        }else{
            System.out.println("check time OK");
        }
    }
}
