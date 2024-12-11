package org.yj.application.data.design.pattern.factory;

public class ProductFactoryB implements ProductFactory {


    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
