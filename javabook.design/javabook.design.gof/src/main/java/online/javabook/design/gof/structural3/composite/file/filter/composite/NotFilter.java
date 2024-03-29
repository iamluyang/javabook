package online.javabook.design.gof.structural3.composite.file.filter.composite;

import online.javabook.design.gof.structural3.composite.file.filter.IFilter;

import java.io.File;

public class NotFilter implements IFilter {

    private IFilter filter;

    public NotFilter(IFilter filter) {
        this.filter = filter;
    }

    @Override
    public boolean accept(File file) {
        return !filter.accept(file);
    }
}
