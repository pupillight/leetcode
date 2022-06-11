package org.yj.application.data.collections;

import org.yj.application.data.structure.tree.binary.Bst;

public class BstSet<E extends Comparable<E>> implements Set<E> {
    private Bst<E> bst;
    public BstSet() {
        bst = new Bst<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public void remove(E e) {
        bst.delete(e);
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public int size() {
        return bst.size;
    }
}
