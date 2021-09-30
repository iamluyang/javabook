package online.javabook.design.gof.structural3.composite.file.filter;

import java.io.File;

public class CanReadFilter implements IFilter {

    @Override
    public boolean accept(File file) {
        return file.canRead();
    }
}
