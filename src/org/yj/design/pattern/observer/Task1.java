package org.yj.design.pattern.observer;

public class Task1 implements Observer {

    private Subject subject;

    public Task1(Subject subject) {
        this.subject = subject;
        this.subject.addObserver(this);
    }

    @Override
    public void update(Object obj) {
        System.out.println(obj);
    }
}
