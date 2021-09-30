package online.javabook.design.spi.impl2;


import online.javabook.design.spi.base.api.ISimpleSpiService;

public class SimpleSpiServiceImpl2 implements ISimpleSpiService {
    @Override
    public String hello(String name) {
        return name.toLowerCase();
    }
}
