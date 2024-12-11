package org.yj.application.data.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notice() {

        for (Observer observer : observers) {
            observer.update();
        }
    }
}
