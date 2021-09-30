package online.javabook.design.gof.behavioral9.template2.login.template;

import online.javabook.design.gof.behavioral9.template2.login.service.LoginService;

public class FacebookLoginService extends LoginService {
    @Override
    protected boolean checkAccount(String userName, String password) {
        System.out.println("Check Facebook account");
        return true;
    }

    @Override
    protected void handlerLogin(String userName) {
        System.out.println("send a Facebook login message");
    }

    @Override
    protected void handlerError(String userName) {
        System.out.println("send a Facebook error message");
    }
}
