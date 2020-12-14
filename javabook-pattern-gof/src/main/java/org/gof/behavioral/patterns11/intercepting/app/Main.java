package org.gof.behavioral.patterns11.intercepting.app;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpRequest;
import org.gof.behavioral.patterns11.intercepting.httpfilter.HttpRequestAuthInterceptor;
import org.gof.behavioral.patterns11.intercepting.httpfilter.HttpRequestRbacInterceptor;
import org.gof.behavioral.patterns11.intercepting.httpfilter.HttpRequestBodyInterceptor;
import org.gof.behavioral.patterns11.intercepting.httpfilter.HttpRequestTimeInterceptor;
import org.gof.behavioral.patterns11.intercepting.httpfilterchain.HttpFilterChain;
import org.gof.behavioral.patterns2.command2.restful.commands.HttpMethod;

import java.io.UnsupportedEncodingException;

public class Main {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws UnsupportedEncodingException {
        HttpFilterChain httpFilterChain = new HttpFilterChain();
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
        httpRequest.setHeader("Authorization", null);
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
