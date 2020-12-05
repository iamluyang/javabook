package org.gof.behavioral.patterns8.strategy1.sort.app;

import org.gof.behavioral.patterns8.strategy1.sort.strategy.*;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();
        table.addRow(1);
        table.addRow(5);
        table.addRow(2);

        table.setSortStrategy(new QuickSort());
        table.sort();

        table.setSortStrategy(new ParallelSort());
        table.addRow(3);
        table.sort();
    }
}
