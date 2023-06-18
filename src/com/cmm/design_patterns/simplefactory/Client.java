package com.cmm.design_patterns.simplefactory;

public class Client {
    public static void main(String[] args) {
        Car bmw =CarFactory.createCar("bmw");
        Car aodi =CarFactory.createCar("aodi");
        bmw.run();
        aodi.run();
    }
}
