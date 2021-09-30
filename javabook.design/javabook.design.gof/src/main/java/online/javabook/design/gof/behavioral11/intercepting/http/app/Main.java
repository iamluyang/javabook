package online.javabook.design.gof.behavioral11.intercepting.http.app;

import online.javabook.design.gof.behavioral11.intercepting.http.filter.HttpRequestAuthInterceptor;
import online.javabook.design.gof.behavioral11.intercepting.http.filter.HttpRequestRbacInterceptor;
import online.javabook.design.gof.behavioral11.intercepting.http.filter.HttpRequestTimeInterceptor;
import online.javabook.design.gof.behavioral11.intercepting.http.filterchain.HttpInterceptorChain;

import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpInterceptorChain httpFilterChain = new HttpInterceptorChain();
        httpFilterChain.addFilter(new HttpRequestTimeInterceptor());
        httpFilterChain.addFilter(new HttpRequestAuthInterceptor());
        httpFilterChain.addFilter(new HttpRequestRbacInterceptor());

        try {
            httpFilterChain.execute(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
