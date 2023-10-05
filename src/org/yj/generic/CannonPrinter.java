package org.yj.generic;

public class CannonPrinter<T> extends RegularPrinter<T>{
    @Override
    public void print(T t) {
        System.out.println(t);

    }
}
