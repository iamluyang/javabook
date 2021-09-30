package online.javabook.jdk.java8.lambdas;

public class LambdaMain {

    public static void main(String[] args) {

        call(1, 2, Integer::max);
    }

    public static void call(int a, int b, MathOperation fun) {
        System.out.println(fun.run(a, b));
    }
}
