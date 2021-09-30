package online.javabook.design.spi.impl1;


import online.javabook.design.spi.base.api.ISimpleSpiService;

public class SimpleSpiServiceImpl1 implements ISimpleSpiService {
    @Override
    public String hello(String name) {
        return name.toUpperCase();
    }
}
