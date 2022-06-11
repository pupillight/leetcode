package org.yj.lambda;

@FunctionalInterface
public interface Filter<T> {

    public boolean test(T o);
}
