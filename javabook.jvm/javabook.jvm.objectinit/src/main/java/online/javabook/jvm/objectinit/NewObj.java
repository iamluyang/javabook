package online.javabook.jvm.objectinit;

public class NewObj {
    public static void main(String[] args) {

        /**
         0 new #2 <online/javabook/jvm/objectinit/Obj>
         3 dup
         4 iconst_1
         5 invokespecial #3 <online/javabook/jvm/objectinit/Obj.<init> : (I)V>
         8 astore_1
         9 return
         */
        Obj obj = new Obj(1);
    }
}
