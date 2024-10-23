package com.berre.repository;

import com.berre.repository.entity.Satis;

import com.berre.repository.entity.SatisDetay;
import com.berre.utility.MyRepositoryFactory;



public class SatisRepository extends MyRepositoryFactory<Satis,Long> {


    public SatisRepository() {
        super(Satis.class);
    }
}
