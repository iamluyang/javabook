package org.gof.behavioral.patterns11.intercepting.http.app;

import com.google.gson.Gson;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestAuthInterceptor;
import org.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestBodyInterceptor;
import org.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestRbacInterceptor;
import org.gof.behavioral.patterns11.intercepting.http.filter.HttpRequestTimeInterceptor;
import org.gof.behavioral.patterns11.intercepting.http.filterchain.HttpInterceptorChain;

import java.io.UnsupportedEncodingException;

public class Main {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpInterceptorChain httpFilterChain = new HttpInterceptorChain();
        httpFilterChain.addFilter(new HttpRequestTimeInterceptor());
        httpFilterChain.addFilter(new HttpRequestAuthInterceptor());
        httpFilterChain.addFilter(new HttpRequestBodyInterceptor());
        httpFilterChain.addFilter(new HttpRequestRbacInterceptor());

        try {
            httpFilterChain.execute(createHttpPost());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HttpPost createHttpPost() throws UnsupportedEncodingException {
        HttpPost httpRequest = new HttpPost();
        httpRequest.setHeader("Authorization", "xxx");
        httpRequest.setEntity(new StringEntity(gson.toJson(getUser())));
        return httpRequest;
    }

    private static User getUser(){
        User user = new User();
        user.setName("xxx");
        user.setAge(44488);
        user.setTrue(true);
        user.setFalse(false);
        user.setEmail("xxx@email.com");
        user.setIp("255.22.22.22");
        return user;
    }
}
