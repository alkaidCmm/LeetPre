package com.cmm.design_patterns.simplefactory;

public class CarFactory {

    /**
     * 基于key创建具体的类
     * @param carName
     * @return
     */
    public static Car createCar(String carName){
        if("aodi".equals(carName)){
            return new Aodi();
        }else if("bmw".equals(carName)){
            return new Bmw();
        }else{
            return null;
        }
    }

    public static Car createCar2(String carName) {
        Car car =null;
        try {
            car = (Car) Class.forName(carName).newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return car;
    }
}
