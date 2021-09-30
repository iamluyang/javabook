package online.javabook.jdk.java8.defaultmethods;

public class ChildHasTwoInterfaces implements IParent2, IParent1 {

    @Override
    public void print() {
        System.out.println("我是ChildHasTwoInterfaces");
    }

    public static void main(String[] args) {
        ChildHasTwoInterfaces childHasTwoInterfaces1 = new ChildHasTwoInterfaces();
        childHasTwoInterfaces1.print();

        IParent1 parent1 = new ChildHasTwoInterfaces();
        parent1.print();

        IParent2 parent2 = new ChildHasTwoInterfaces();
        parent2.print();
    }
}
