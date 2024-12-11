package org.yj.application.data.design.pattern.strategy;

public class Array {

    private Sorter sorter;

    public Array() {
        sorter = new MergeSorter();
    }

    public void sort( ) {

        sorter.sort();
    }

    public void sort(Sorter sorter) {
        sorter.sort();
    }
}
