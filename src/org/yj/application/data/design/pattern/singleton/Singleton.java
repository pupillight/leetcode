package org.yj.application.data.design.pattern.singleton;

public class Singleton {
    private volatile static Singleton instance;

    private final static Object lock = new Object();

    private Singleton() {

    }

    /*    public synchronized static Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }*/
    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (lock) { //t1 t2 t3 block here
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
