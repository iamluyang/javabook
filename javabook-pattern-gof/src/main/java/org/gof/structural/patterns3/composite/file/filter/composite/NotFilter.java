package org.gof.structural.patterns3.composite.file.filter.composite;

import org.gof.structural.patterns3.composite.file.filter.IFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
