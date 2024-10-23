package com.berre.repository;

import com.berre.repository.entity.Car;
import com.berre.utility.MyRepositoryFactory;

public class CarRepository extends MyRepositoryFactory<Car, Long> {
    public CarRepository() {
        super(Car.class);
    }
}
