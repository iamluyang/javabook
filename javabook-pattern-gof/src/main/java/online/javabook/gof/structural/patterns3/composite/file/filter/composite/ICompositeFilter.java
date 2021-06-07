package online.javabook.gof.structural.patterns3.composite.file.filter.composite;

import online.javabook.gof.structural.patterns3.composite.file.filter.IFilter;

public interface ICompositeFilter extends IFilter {

    public void addFilter(IFilter filter);

    public void delFilter(IFilter filter);
}
