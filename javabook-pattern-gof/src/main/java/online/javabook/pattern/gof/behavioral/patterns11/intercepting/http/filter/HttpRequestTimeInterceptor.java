package online.javabook.pattern.gof.behavioral.patterns11.intercepting.http.filter;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class HttpRequestTimeInterceptor implements IHttpRequestInterceptor {
    @Override
    public void execute(HttpServletRequest request) throws Exception {
        Calendar c = Calendar.getInstance();

        if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            throw new Exception("非工作日");
        }else{
            System.out.println("check time OK");
        }
    }
}
