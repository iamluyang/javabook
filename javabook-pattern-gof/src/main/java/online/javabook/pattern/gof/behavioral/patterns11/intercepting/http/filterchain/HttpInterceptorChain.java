package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filterchain;

import online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter.IHttpRequestInterceptor;
import org.apache.http.HttpRequest;

import java.util.ArrayList;
import java.util.List;

public class HttpInterceptorChain {

    private List<IHttpRequestInterceptor> interceptors = new ArrayList<IHttpRequestInterceptor>();

    public void addFilter(IHttpRequestInterceptor filter){
        interceptors.add(filter);
    }

    public void removeFilter(IHttpRequestInterceptor filter){
        interceptors.remove(filter);
    }

    public void execute(HttpRequest request) throws Exception {
        for (IHttpRequestInterceptor interceptor : interceptors) {
            interceptor.execute(request);
        }
    }
}
