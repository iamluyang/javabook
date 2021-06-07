package online.javabook.gof.structural.patterns3.composite.file.filter.composite;

import online.javabook.gof.structural.patterns3.composite.file.filter.IFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AndCompositeFilter implements ICompositeFilter {

    private List<IFilter> andFilters = new ArrayList<>();

    @Override
    public boolean accept(File file) {
        for (IFilter filter : andFilters){
            boolean isTrue = filter.accept(file);
            if(!isTrue) return false;
        }
        return true;
    }

    @Override
    public void addFilter(IFilter filter) {
        andFilters.add(filter);
    }

    @Override
    public void delFilter(IFilter filter) {
        andFilters.remove(filter);
    }
}
