package online.javabook.design.gof.behavioral7.state1.trafficlight.app.bad;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String light = "Red";

        while(true){
            if(light.equals("Red")){
                System.out.println("现在是红灯 请等待10秒");
                TimeUnit.SECONDS.sleep(10);
                light = "Green";

            }else if(light.equals("Green")){
                System.out.println("现在是绿灯 请等待5秒");
                TimeUnit.SECONDS.sleep(5);
                light = "Yellow";

            }else if(light.equals("Yellow")){
                System.out.println("现在是黄灯 请等待3秒");
                TimeUnit.SECONDS.sleep(3);
                light = "Red";

            }
        }
    }
}
