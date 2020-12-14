package org.gof.behavioral.patterns9.template2.login.app.good;

import org.gof.behavioral.patterns9.template2.login.service.LoginService;
import org.gof.behavioral.patterns9.template2.login.template.FacebookLoginService;
import org.gof.behavioral.patterns9.template2.login.template.GoogleLoginService;
import org.gof.behavioral.patterns9.template2.login.template.YouTubeLoginService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String loginType = "google";
        Map<String, LoginService> loginServiceRegister = new HashMap<>();
        loginServiceRegister.put("google", new GoogleLoginService());
        loginServiceRegister.put("facebook", new FacebookLoginService());
        loginServiceRegister.put("youtube", new YouTubeLoginService());

        LoginService loginService = loginServiceRegister.get(loginType);
        loginService.login("xxx", "yyy");
    }
}
