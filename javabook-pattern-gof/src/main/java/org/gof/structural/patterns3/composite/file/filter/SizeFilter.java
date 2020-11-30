package org.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public class SizeFilter implements IFilter {

    private int size;

    public SizeFilter(int size) {
        this.size = size;
    }

    @Override
    public boolean accept(File file) {
        return file.length() <= size;
    }
}
