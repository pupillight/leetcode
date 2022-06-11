package org.yj.application.data.collections;

public interface Set<E> {

    void add(E e);
    boolean contains(E e);
    void remove(E e);
    boolean isEmpty();
    int size();

}
