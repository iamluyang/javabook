package online.javabook.jvm.bytecode.invokevirtual;

public class Dog implements IAnimal {
    @Override
    public void eat() {
        System.out.println("meat");
    }
}
