package online.javabook.jdk.java8.defaultmethods;

public class ChildHasOneInterface implements IParent1 {

    public static void main(String[] args) {
        IParent1 childHasOneInterface1 = new ChildHasOneInterface();
        childHasOneInterface1.print();

        ChildHasOneInterface childHasOneInterface2 = new ChildHasOneInterface();
        childHasOneInterface2.print();
    }
}
