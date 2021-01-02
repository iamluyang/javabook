package online.javabook.pattern.gof.structural.patterns3.composite.file.app.good;

import online.javabook.pattern.gof.structural.patterns3.composite.file.filter.*;
import online.javabook.pattern.gof.structural.patterns3.composite.file.filter.composite.AndCompositeFilter;
import online.javabook.pattern.gof.structural.patterns3.composite.file.filter.composite.ICompositeFilter;
import online.javabook.pattern.gof.structural.patterns3.composite.file.filter.composite.OrCompositeFilter;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        ICompositeFilter and = new AndCompositeFilter();

        and.addFilter(new CanExecuteFilter());
        and.addFilter(new CanReadFilter());
        and.addFilter(new CanWriteFilter());
        and.addFilter(new PrefixFilter("a"));
        and.addFilter(new SuffixFilter("c"));

        and.accept(new File("abc.txt"));

        // ------------------------------------------------------------------

        ICompositeFilter or = new OrCompositeFilter();

        ICompositeFilter and1 = new AndCompositeFilter();
        and1.addFilter(new CanExecuteFilter());
        and1.addFilter(new CanReadFilter());
        and1.addFilter(new CanWriteFilter());

        ICompositeFilter and2 = new AndCompositeFilter();
        and2.addFilter(new PrefixFilter("a"));
        and2.addFilter(new SuffixFilter("c"));

        or.addFilter(and1);
        or.addFilter(and2);

        // where (CanExecuteFilter and CanReadFilter and CanWriteFilter)  or (PrefixFilter and SuffixFilter)
        or.accept(new File("abc.txt"));
    }
}
