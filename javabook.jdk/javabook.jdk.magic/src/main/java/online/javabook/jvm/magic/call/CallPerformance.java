package online.javabook.jvm.magic.call;

public class CallPerformance {
    public static void main(String[] args) {

        ObjectTest objectTest;
        long count = 10000 * 10000;

        long start1 =  System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            objectTest = new ObjectTest();
            objectTest.testMethod();
        }
        long finish1 =  System.currentTimeMillis();
        System.out.println("Performance testObjectMethod:" + (finish1 - start1));

        long start2 =  System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            ClassTest.testMethod();
        }
        long finish2 =  System.currentTimeMillis();
        System.out.println("Performance testStaticMethod:" + (finish2 - start2));
    }
}
