package online.javabook.jdk.java8.defaultmethods;

public interface IParent2 {
    default void print(){
        System.out.println("我是IParent2");
    }
}
