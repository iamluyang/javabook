package org.gof.behavioral.patterns1.intercepting.app;

import com.sun.deploy.net.BasicHttpRequest;
import org.gof.behavioral.patterns1.intercepting.httpfilter.HttpAuthFilter;
import org.gof.behavioral.patterns1.intercepting.httpfilter.HttpRbacFilter;
import org.gof.behavioral.patterns1.intercepting.httpfilter.HttpBodyFilter;
import org.gof.behavioral.patterns1.intercepting.httpfilter.HttpTimeFilter;
import org.gof.behavioral.patterns1.intercepting.httpfilterchain.HttpFilterChain;

public class Main {
    public static void main(String[] args) {
        HttpFilterChain httpFilterChain = new HttpFilterChain();
        httpFilterChain.addFilter(new HttpTimeFilter());
        httpFilterChain.addFilter(new HttpAuthFilter());
        httpFilterChain.addFilter(new HttpBodyFilter());
        httpFilterChain.addFilter(new HttpRbacFilter());

        httpFilterChain.execute(new BasicHttpRequest());
    }
}
