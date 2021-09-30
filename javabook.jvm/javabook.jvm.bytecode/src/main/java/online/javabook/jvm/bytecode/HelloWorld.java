package online.javabook.jvm.bytecode;

public class HelloWorld implements Comparable {

    public int field1;

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public void methodA() throws Exception {
        System.out.println("Hello world");
        throw new Exception();
    }
}
