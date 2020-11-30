package org.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public class SuffixFilter implements IFilter {

    private String suffix;

    public SuffixFilter(String suffix) {
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File file) {
        return file.getName().endsWith(suffix);
    }
}
