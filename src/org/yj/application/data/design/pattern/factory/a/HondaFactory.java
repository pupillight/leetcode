package org.yj.application.data.design.pattern.factory.a;

public class HondaFactory implements AbstractFactory {
    @Override
    public Car createCar() {
        return new HondaCar();
    }

    @Override
    public Truck createTruck() {
        return new HondaTruck();
    }
}
