package com.berre.repository;

import com.berre.repository.entity.Musteri;

import com.berre.repository.entity.SatisDetay;
import com.berre.utility.MyRepositoryFactory;


import java.util.List;

public class MusteriRepository extends MyRepositoryFactory<Musteri,Long> {


    public MusteriRepository() {
        super(Musteri.class);
    }
}
