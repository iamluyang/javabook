package online.javabook.jvm.bytecode.invokevirtual;

/**
 * 静态编译（前期绑定）与动态编译（后期绑定）
 *
 */
public class VirtualMethodByteCode extends Parent {

    /**
     0 aload_0
     1 invokespecial #2 <java/lang/Object.toString : ()Ljava/lang/String;>
     4 pop
     5 invokestatic #3 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.thisIsStaticMethod : ()V>
     8 aload_0
     9 invokespecial #4 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.thisIsPrivateMethod : ()V>
     12 aload_0
     13 invokespecial #5 <online/javabook/jvm/bytecode/virtual/Parent.thisIsFinalMethodInParent : ()V>
     16 aload_0
     17 invokevirtual #6 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.thisIsFinalMethod : ()V>
     20 aload_0
     21 invokevirtual #7 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.thisIsPublicMethod : ()V>
     24 aload_0
     25 invokespecial #8 <online/javabook/jvm/bytecode/virtual/Parent.thisIsPublicMethodInParent : ()V>
     28 aload_0
     29 new #9 <online/javabook/jvm/bytecode/virtual/Cat>
     32 dup
     33 invokespecial #10 <online/javabook/jvm/bytecode/virtual/Cat.<init> : ()V>
     36 invokevirtual #11 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.feedAnimal : (Lonline/javabook/jvm/bytecode/virtual/IAnimal;)V>
     39 aload_0
     40 new #12 <online/javabook/jvm/bytecode/virtual/Dog>
     43 dup
     44 invokespecial #13 <online/javabook/jvm/bytecode/virtual/Dog.<init> : ()V>
     47 invokevirtual #11 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.feedAnimal : (Lonline/javabook/jvm/bytecode/virtual/IAnimal;)V>
     50 aload_0
     51 new #9 <online/javabook/jvm/bytecode/virtual/Cat>
     54 dup
     55 invokespecial #10 <online/javabook/jvm/bytecode/virtual/Cat.<init> : ()V>
     58 invokevirtual #14 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.feedCat : (Lonline/javabook/jvm/bytecode/virtual/Cat;)V>
     61 aload_0
     62 new #12 <online/javabook/jvm/bytecode/virtual/Dog>
     65 dup
     66 invokespecial #13 <online/javabook/jvm/bytecode/virtual/Dog.<init> : ()V>
     69 invokevirtual #15 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.feedDog : (Lonline/javabook/jvm/bytecode/virtual/Dog;)V>
     72 aload_0
     73 new #16 <online/javabook/jvm/bytecode/virtual/Car>
     76 dup
     77 invokespecial #17 <online/javabook/jvm/bytecode/virtual/Car.<init> : ()V>
     80 invokevirtual #18 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.runMachine : (Lonline/javabook/jvm/bytecode/virtual/Machine;)V>
     83 aload_0
     84 new #19 <online/javabook/jvm/bytecode/virtual/Ship>
     87 dup
     88 invokespecial #20 <online/javabook/jvm/bytecode/virtual/Ship.<init> : ()V>
     91 invokevirtual #18 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.runMachine : (Lonline/javabook/jvm/bytecode/virtual/Machine;)V>
     94 aload_0
     95 new #16 <online/javabook/jvm/bytecode/virtual/Car>
     98 dup
     99 invokespecial #17 <online/javabook/jvm/bytecode/virtual/Car.<init> : ()V>
     102 invokevirtual #21 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.runCar : (Lonline/javabook/jvm/bytecode/virtual/Car;)V>
     105 aload_0
     106 new #19 <online/javabook/jvm/bytecode/virtual/Ship>
     109 dup
     110 invokespecial #20 <online/javabook/jvm/bytecode/virtual/Ship.<init> : ()V>
     113 invokevirtual #22 <online/javabook/jvm/bytecode/virtual/VirtualMethodByteCode.runShip : (Lonline/javabook/jvm/bytecode/virtual/Ship;)V>
     116 return
     */
    public void main() {

        super.toString();
        thisIsStaticMethod();
        thisIsPrivateMethod();
        super.thisIsFinalMethodInParent();
        thisIsFinalMethod();

        thisIsPublicMethod(); // invokevirtual 子类可能重写，因此不能确定下来
        super.thisIsPublicMethodInParent(); // invokespecial，明确的调用了父类中的方法
        feedAnimal(new Cat());
        feedAnimal(new Dog());
        feedCat(new Cat());
        feedDog(new Dog());

        runMachine(new Car());
        runMachine(new Ship());
        runCar(new Car());
        runShip(new Ship());
    }

    public void thisIsPublicMethod() {

    }

    public final void thisIsFinalMethod() {

    }

    /**
     0 aload_1
     1 invokeinterface #21 <online/javabook/jvm/bytecode/invokevirtual/IAnimal.eat : ()V> count 1
     6 return

     * 动态编译（后期绑定）
     * @param animal
     */
    public void feedAnimal(IAnimal animal) {
        animal.eat();
    }

    /**
     0 aload_1
     1 invokevirtual #22 <online/javabook/jvm/bytecode/invokevirtual/Cat.eat : ()V>
     4 return

     * 静态编译（前期绑定）
     * @param animal
     */
    public void feedCat(Cat animal) {
        animal.eat();
    }

    /**
     0 aload_1
     1 invokevirtual #23 <online/javabook/jvm/bytecode/invokevirtual/Dog.eat : ()V>
     4 return

     * 静态编译（前期绑定）
     * @param animal
     */
    public void feedDog(Dog animal) {
        animal.eat();
    }

    // ----------------------------------------------

    /**
     0 aload_1
     1 invokevirtual #24 <online/javabook/jvm/bytecode/invokevirtual/Machine.run : ()V>
     4 return
     */
    public void runMachine(Machine machine) {
        machine.run();
    }

    /**
     0 aload_1
     1 invokevirtual #25 <online/javabook/jvm/bytecode/invokevirtual/Car.run : ()V>
     4 return
     */
    public void runCar(Car machine) {
        machine.run();
    }

    /**
     0 aload_1
     1 invokevirtual #26 <online/javabook/jvm/bytecode/invokevirtual/Ship.run : ()V>
     4 return
     */
    public void runShip(Ship machine) {
        machine.run();
    }

    // ----------------------------------------------
    // 非虚方法（静态编译期间就能确定具体的调用）
    // ----------------------------------------------

    /**
     * 调用静态方法，私有方法，实例构造器，父类方法，final方法都是非虚方法
     */
    public static void thisIsStaticMethod() {

    }

    /**
     * 调用静态方法，私有方法，实例构造器，父类方法，final方法都是非虚方法
     */
    private void thisIsPrivateMethod() {

    }
}
