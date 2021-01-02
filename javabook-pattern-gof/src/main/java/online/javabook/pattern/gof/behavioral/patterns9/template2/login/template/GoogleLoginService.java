package online.javabook.pattern.gof.behavioral.patterns9.template2.login.template;

import online.javabook.pattern.gof.behavioral.patterns9.template2.login.service.LoginService;

public class GoogleLoginService extends LoginService {
    @Override
    protected boolean checkAccount(String userName, String password) {
        System.out.println("Check Google account");
        return true;
    }

    @Override
    protected void handlerLogin(String userName) {
        System.out.println("send a Google login message");
    }

    @Override
    protected void handlerError(String userName) {
        System.out.println("send a Google error message");
    }
}
