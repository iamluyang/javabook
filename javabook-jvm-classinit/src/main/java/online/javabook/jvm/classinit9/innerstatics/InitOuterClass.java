package online.javabook.jvm.classinit9.innerstatics;

import online.javabook.jvm.classinit.OuterClass;

public class InitOuterClass {
    public static void main(String[] args) {
        System.out.println(OuterClass.getInner());
    }
}
