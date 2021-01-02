package online.javabook.classinit;

public class OuterClass {

    static {
        System.out.println("Init OuterClass");
    }

    private static class InnerClass {
        static {
            System.out.println("Init InnerClass");
        }
        private static final OuterClass INSTANCE = new OuterClass();
    }

    private OuterClass(){

    }

    public static final OuterClass getInner() {
        return InnerClass.INSTANCE;
    }
}