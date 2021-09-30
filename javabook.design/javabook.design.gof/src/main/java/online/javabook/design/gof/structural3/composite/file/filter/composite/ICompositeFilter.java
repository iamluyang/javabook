package online.javabook.design.gof.structural3.composite.file.filter.composite;

import online.javabook.design.gof.structural3.composite.file.filter.IFilter;

public interface ICompositeFilter extends IFilter {

    public void addFilter(IFilter filter);

    public void delFilter(IFilter filter);
}
