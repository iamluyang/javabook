package online.javabook.design.gof.structural3.composite.file.filter;

import java.io.File;

public interface IFilter {

    boolean accept(File file);
}
