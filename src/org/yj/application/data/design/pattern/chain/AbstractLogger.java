package org.yj.application.data.design.pattern.chain;

public abstract class AbstractLogger implements Logger{

    protected Logger next;

    @Override
    public Logger getNext() {
        return next;
    }

    public void setNext(Logger next) {
        this.next = next;
    }
}
