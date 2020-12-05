package org.gof.behavioral.patterns8.strategy1.sort.strategy;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private ISortStrategy sortStrategy;

    private List<Integer> results = new ArrayList();

    public ISortStrategy getSortStrategy() {
        return sortStrategy;
    }

    public void setSortStrategy(ISortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    public void sort() {
        Integer[] array = sortStrategy.Sort(results);
        for (int row : array){
            System.out.println(row);
        }
    }

    public void addRow(int data) {
        results.add(data);
    }

    public void deleteRow(int data) {
        results.add(data);
    }
}
