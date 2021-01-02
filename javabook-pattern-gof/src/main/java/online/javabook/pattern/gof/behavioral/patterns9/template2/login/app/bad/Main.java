package online.javabook.pattern.gof.behavioral.patterns9.template2.login.app.bad;

public class Main {
    public static void main(String[] args) {

        String social = "google";
        String userName = "xxx";
        String password = "yyy";

        switch (social) {
            case "google":{
                boolean isOK = checkGoogleAccount(userName, password);
                if(isOK) {
                    handlerGoogleLogin(userName);
                }else{
                    handlerGoogleError(userName);
                }
                break;
            }
            case "facebook":{
                boolean isOK = checkFacebookAccount(userName, password);
                if(isOK) {
                    handlerFacebookLogin(userName);
                }else{
                    handlerFacebookError(userName);
                }
                break;
            }
            case "youtube":{
                boolean isOK = checkYoutubeAccount(userName, password);
                if(isOK) {
                    handlerYoutubeLogin(userName);
                }else{
                    handlerYoutubeError(userName);
                }
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + social);
        }
    }

    // -----------------------------------------------------

    protected static boolean checkFacebookAccount(String userName, String password) {
        System.out.println("Check Facebook account");
        return true;
    }

    protected static void handlerFacebookLogin(String userName) {
        System.out.println("send a Facebook login message");
    }

    protected static void handlerFacebookError(String userName) {
        System.out.println("send a Facebook error message");
    }

    // -----------------------------------------------------

    protected static boolean checkGoogleAccount(String userName, String password) {
        System.out.println("Check Google account");
        return true;
    }

    protected static void handlerGoogleLogin(String userName) {
        System.out.println("send a Google login message");
    }

    protected static void handlerGoogleError(String userName) {
        System.out.println("send a Google error message");
    }
    // -----------------------------------------------------

    protected static boolean checkYoutubeAccount(String userName, String password) {
        System.out.println("Check YouTube account");
        return true;
    }

    protected static void handlerYoutubeLogin(String userName) {
        System.out.println("send a youtube login message");
    }

    protected static void handlerYoutubeError(String userName) {
        System.out.println("send a youtube error message");
    }
}
