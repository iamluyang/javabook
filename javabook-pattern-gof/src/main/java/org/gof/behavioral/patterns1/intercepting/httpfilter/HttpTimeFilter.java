package org.gof.behavioral.patterns1.intercepting.httpfilter;

import org.apache.http.HttpRequest;

import java.util.Calendar;

public class HttpTimeFilter implements IHttpFilter  {
    @Override
    public void execute(HttpRequest request) throws Exception {
        Calendar c = Calendar.getInstance();

        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            throw new Exception("非工作日");
        }
    }
}
