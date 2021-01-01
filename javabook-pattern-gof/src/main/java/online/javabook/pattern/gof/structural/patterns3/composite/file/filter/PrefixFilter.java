package online.javabook.pattern.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public class PrefixFilter implements IFilter {

    private String prefix;

    public PrefixFilter(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean accept(File file) {
        return file.getName().startsWith(prefix);
    }
}
