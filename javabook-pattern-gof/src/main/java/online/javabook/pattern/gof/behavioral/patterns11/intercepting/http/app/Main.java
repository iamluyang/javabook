package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.app;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestAuthInterceptor;
import online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestRbacInterceptor;
import online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestTimeInterceptor;
import online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filterchain.HttpInterceptorChain;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpInterceptorChain httpFilterChain = new HttpInterceptorChain();
        httpFilterChain.addFilter(new HttpRequestTimeInterceptor());
        httpFilterChain.addFilter(new HttpRequestAuthInterceptor());
        httpFilterChain.addFilter(new HttpRequestRbacInterceptor());

        try {
            httpFilterChain.execute(createHttpServletRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
