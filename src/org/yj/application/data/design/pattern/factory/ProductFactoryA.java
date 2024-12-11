package org.yj.application.data.design.pattern.factory;

public class ProductFactoryA implements ProductFactory {


    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
