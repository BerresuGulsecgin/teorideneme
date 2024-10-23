package com.berre.repository;

import com.berre.entity.Car;
import com.berre.entity.DealersShip;
import com.berre.utility.MyRepositoryFactory;

public class DealersShipRepository extends MyRepositoryFactory<DealersShip, Long> {
    public DealersShipRepository() {
        super(DealersShip.class);
    }
}
