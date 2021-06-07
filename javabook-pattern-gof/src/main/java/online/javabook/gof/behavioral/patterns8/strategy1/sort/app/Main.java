package online.javabook.gof.behavioral.patterns8.strategy1.sort.app;

import online.javabook.gof.behavioral.patterns8.strategy1.sort.strategy.ParallelSort;
import online.javabook.gof.behavioral.patterns8.strategy1.sort.strategy.DefaultSort;
import online.javabook.gof.behavioral.patterns8.strategy1.sort.strategy.Table;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.addRow(1);
        table.addRow(5);
        table.addRow(2);

        table.setSortStrategy(new DefaultSort());
        table.sort();

        table.setSortStrategy(new ParallelSort());
        table.addRow(3);
        table.sort();
    }
}
