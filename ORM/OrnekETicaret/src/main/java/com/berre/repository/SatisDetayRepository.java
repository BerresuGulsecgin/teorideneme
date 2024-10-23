package com.berre.repository;

import com.berre.repository.entity.SatisDetay;
import com.berre.utility.MyRepositoryFactory;

public class SatisDetayRepository extends MyRepositoryFactory<SatisDetay,Long> {

    public SatisDetayRepository() {
        super(SatisDetay.class);
    }
}
