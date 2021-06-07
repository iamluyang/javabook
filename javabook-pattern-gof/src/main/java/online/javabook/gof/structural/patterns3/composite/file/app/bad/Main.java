package online.javabook.gof.structural.patterns3.composite.file.app.bad;

import online.javabook.gof.structural.patterns3.composite.file.filter.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        // ------------------------------------------------------------------

        File file = new File("abc.txt.");
        if( file.isHidden() != true ||
            file.canExecute() == true ||
            file.canWrite() == true ||
            file.canRead() == true ||
            file.length() <= 100 ||
            file.getName().startsWith("a") ||
            file.getName().endsWith("c")) {

            System.out.println("I am abc.txt");
        }

        // ------------------------------------------------------------------

        File file2 = new File("def.txt.");
        if( file2.isHidden() != true
                &&
                (file2.canExecute() == true ||
                file2.canWrite() == true ||
                file2.canRead() == true )
                &&
                (file2.length() <= 100 ||
                        file2.getName().startsWith("a") ||
                        file2.getName().endsWith("c"))) {

            System.out.println("I am def.txt");
        }

        // ------------------------------------------------------------------

        File file3 = new File("hij.txt.");
        if( new HiddenFilter().accept(file3)
                &&
                (new CanExecuteFilter().accept(file3)  ||
                        new CanReadFilter().accept(file3) ||
                        new CanWriteFilter().accept(file3) )
                &&
                (new PrefixFilter("a").accept(file3) ||
                        new SuffixFilter("c").accept(file3) ||
                        new SizeFilter(100).accept(file3) )) {

            System.out.println("I am def.txt");
        }
    }
}
