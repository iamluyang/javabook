package org.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public class HiddenFilter implements IFilter {

    @Override
    public boolean accept(File file) {
        return file.isHidden();
    }
}
