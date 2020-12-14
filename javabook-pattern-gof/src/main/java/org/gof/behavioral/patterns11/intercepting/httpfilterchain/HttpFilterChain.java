package org.gof.behavioral.patterns11.intercepting.httpfilterchain;

import org.apache.http.HttpRequest;
import org.gof.behavioral.patterns11.intercepting.httpfilter.IHttpRequestInterceptor;

import java.util.ArrayList;
import java.util.List;

public class HttpFilterChain {

    private List<IHttpRequestInterceptor> filters = new ArrayList<IHttpRequestInterceptor>();

    public void addFilter(IHttpRequestInterceptor filter){
        filters.add(filter);
    }

    public void removeFilter(IHttpRequestInterceptor filter){
        filters.remove(filter);
    }

    public void execute(HttpRequest request) throws Exception {
        for (IHttpRequestInterceptor filter : filters) {
            filter.execute(request);
        }
    }
}
