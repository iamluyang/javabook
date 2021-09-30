package online.javabook.design.spi.client;


import online.javabook.design.spi.base.api.ISimpleSpiService;
import online.javabook.design.spi.base.api.SimpleSpiFactory;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ISimpleSpiService simpleSpiService1 = SimpleSpiFactory.getDefaultSimpleSpiService();
        System.out.println(simpleSpiService1.hello("hElLo"));

        Iterator<ISimpleSpiService> simpleSpiServices = SimpleSpiFactory.getAllSimpleSpiService();
        while (simpleSpiServices.hasNext()) {
            System.out.println(simpleSpiServices.next());
        }
    }
}
