package com.berre.repository;

import com.berre.repository.entity.Address;
import com.berre.utility.MyRepositoryFactory;

public class AddressRepository extends MyRepositoryFactory<Address, Long> {
    public AddressRepository() {
        super(Address.class);
    }
}
