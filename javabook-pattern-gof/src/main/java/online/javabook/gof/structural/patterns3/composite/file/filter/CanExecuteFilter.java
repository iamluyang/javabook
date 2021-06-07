package online.javabook.gof.structural.patterns3.composite.file.filter;

import java.io.File;

public class CanExecuteFilter implements IFilter {

    @Override
    public boolean accept(File file) {
        return file.canExecute();
    }
}
