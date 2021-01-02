package online.javabook.pattern.gof.behavioral.patterns9.template2.login.template;

import online.javabook.pattern.gof.behavioral.patterns9.template2.login.service.LoginService;

public class YouTubeLoginService extends LoginService {
    @Override
    protected boolean checkAccount(String userName, String password) {
        System.out.println("Check YouTube account");
        return true;
    }

    @Override
    protected void handlerLogin(String userName) {
        System.out.println("send a youtube login message");
    }

    @Override
    protected void handlerError(String userName) {
        System.out.println("send a youtube error message");
    }
}