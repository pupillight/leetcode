package org.yj.generic;

import java.util.Arrays;

public abstract class Printer<T> {
    public  abstract  void print(T t);

    public <E,K> T println(K k,E... e) {
        Arrays.stream(e).forEach(System.out::println);
        return null;
    }


}
