package org.yj.jvm.learning;

import java.util.ArrayList;

public class JvmTester {

    public static void main(String[] args) {

        java.util.ArrayList list = new ArrayList();
        for (int i = 0; i < 200; i++) {
            list.add(new Student());
        }
        try {
            Thread.sleep(1000000000000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Student {
    private byte[] big = new byte[1024 * 1024];

}
