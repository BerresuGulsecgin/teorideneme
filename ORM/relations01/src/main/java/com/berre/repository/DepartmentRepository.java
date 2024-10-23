package com.berre.repository;

import com.berre.repository.entity.Department;
import com.berre.utility.MyRepositoryFactory;

public class DepartmentRepository extends MyRepositoryFactory<Department, Long> {
    public DepartmentRepository() {
        super(Department.class);
    }
}
