package online.javabook.pattern.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public interface IFilter {

    boolean accept(File file);
}
