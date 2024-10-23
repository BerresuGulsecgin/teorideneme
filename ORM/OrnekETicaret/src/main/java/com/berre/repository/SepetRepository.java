package com.berre.repository;

import com.berre.repository.entity.Sepet;
import com.berre.utility.MyRepositoryFactory;

public class SepetRepository extends MyRepositoryFactory<Sepet,Long> {

    public SepetRepository() {
        super(Sepet.class);
    }
}
