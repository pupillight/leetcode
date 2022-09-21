package org.yj.design.pattern.singleton;

public class SingletonTest {


    private SingletonTest() {
        System.out.println("call constructor.");
    }

    private volatile static SingletonTest instance;

    private static Object obj = new Object();

    public static SingletonTest getInstance() {

        if (instance == null) {
            synchronized (obj) {
                if (instance == null) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }

  /*  private static SingletonTest instance = new SingletonTest();
    public static SingletonTest getInstance() {
        return instance;
    }*/

    public static void main(String[] args) {
        SingletonTest instance = SingletonTest.getInstance();
        System.out.println(instance);
    }

}
