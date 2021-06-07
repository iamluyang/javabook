package online.javabook.gof.structural.patterns4.decorator.coffee.api;

public class DecoratorCoffee implements ICoffee {

    private ICoffee coffee;

    public DecoratorCoffee(ICoffee coffee) {
        this.coffee = coffee;
    }

    public DecoratorCoffee() {

    }

    @Override
    public String getCup() {
        if(coffee!=null) {
            return coffee.getCup();
        }
        else{
            return "";
        }
    }
}
