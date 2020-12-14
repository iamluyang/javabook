package org.gof.behavioral.patterns1.intercepting.httpfilterchain;

import com.sun.deploy.net.HttpRequest;
import org.gof.behavioral.patterns1.intercepting.httpfilter.IHttpFilter;

import java.util.ArrayList;
import java.util.List;

public class HttpFilterChain {

    private List<IHttpFilter> filters = new ArrayList<IHttpFilter>();

    public void addFilter(IHttpFilter filter){
        filters.add(filter);
    }

    public void removeFilter(IHttpFilter filter){
        filters.remove(filter);
    }

    public void execute(HttpRequest request){
        for (IHttpFilter filter : filters) {
            filter.execute(request);
        }
    }
}
