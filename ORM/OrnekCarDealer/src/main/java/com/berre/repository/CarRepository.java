package com.berre.repository;

import com.berre.entity.Car;
import com.berre.utility.MyRepositoryFactory;

public class CarRepository extends MyRepositoryFactory<Car, Long> {
    public CarRepository() {
        super(Car.class);
    }
}
