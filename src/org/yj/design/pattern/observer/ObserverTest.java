package org.yj.design.pattern.observer;

public class ObserverTest {

    public static void main(String[] args) {
        Subject subject = new Subject();
        subject.addObserver(obj -> System.out.println(obj));
        Observer task1 = new Task1(subject);
        subject.update("hello~~");
    }
}
