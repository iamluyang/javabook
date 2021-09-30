package online.javabook.jdk.java8.functionalinterface;

public class HelloServiceMain {
    public static void main(String[] args) {

        HelloService helloService1 = new HelloService() {
            @Override
            public void sayMessage(String message) {
                System.out.println("Hello " + message);
            }
        };
        helloService1.sayMessage("world");

        // ---------------------------------------------

        HelloService helloService2 = message -> System.out.println("Hello " + message);
        helloService2.sayMessage("world");
    }
}
