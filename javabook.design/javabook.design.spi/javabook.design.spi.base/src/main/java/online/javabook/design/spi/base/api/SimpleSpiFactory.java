package online.javabook.design.spi.base.api;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SimpleSpiFactory {

    public static ServiceLoader<ISimpleSpiService> getSimpleSpiService() {
        ServiceLoader<ISimpleSpiService> simpleSpiServices = ServiceLoader.load(ISimpleSpiService.class);
        return simpleSpiServices;
    }

    public static ISimpleSpiService getDefaultSimpleSpiService() {
        ServiceLoader<ISimpleSpiService> simpleSpiServices = ServiceLoader.load(ISimpleSpiService.class);
        return simpleSpiServices.iterator().next();
    }

    public static Iterator<ISimpleSpiService> getAllSimpleSpiService() {
        ServiceLoader<ISimpleSpiService> simpleSpiServices = ServiceLoader.load(ISimpleSpiService.class);
        return simpleSpiServices.iterator();
    }
}
