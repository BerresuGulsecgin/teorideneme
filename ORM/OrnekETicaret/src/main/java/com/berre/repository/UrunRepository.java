package com.berre.repository;


import com.berre.repository.entity.Urun;

import com.berre.utility.MyRepositoryFactory;


public class UrunRepository extends MyRepositoryFactory<Urun,Long> {


    public UrunRepository() {
        super(Urun.class);
    }
}
