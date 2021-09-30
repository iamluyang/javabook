package online.javabook.design.gof.structural3.composite.file.filter.composite;

import online.javabook.design.gof.structural3.composite.file.filter.IFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrCompositeFilter implements ICompositeFilter {

    private List<IFilter> orFilters = new ArrayList<>();

    @Override
    public boolean accept(File file) {
        for (IFilter filter : orFilters){
            boolean isTrue = filter.accept(file);
            if(isTrue) return true;
        }
        return false;
    }

    @Override
    public void addFilter(IFilter filter) {
        orFilters.add(filter);
    }

    @Override
    public void delFilter(IFilter filter) {
        orFilters.remove(filter);
    }
}
