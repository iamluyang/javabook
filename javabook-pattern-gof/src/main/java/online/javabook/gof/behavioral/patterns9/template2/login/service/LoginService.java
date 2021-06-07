package online.javabook.gof.behavioral.patterns9.template2.login.service;

public abstract class LoginService {

    // template method
    public void login(String userName, String password) {
        boolean isOK = checkAccount(userName, password);
        if(isOK) {
            handlerLogin(userName);
        }else{
            handlerError(userName);
        }
    }

    protected abstract boolean checkAccount(String userName, String password);

    protected abstract void handlerLogin(String userName);

    protected abstract void handlerError(String userName);

}
