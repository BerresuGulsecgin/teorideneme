package com.berre.repository;

import com.berre.repository.entity.Personel;
import com.berre.utility.MyRepositoryFactory;

public class PersonelRepository extends MyRepositoryFactory<Personel,Long> {
    public PersonelRepository() {
        super(Personel.class);
    }
}
