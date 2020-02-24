package com.rbs.backendspringboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rbs.backendspringboot.model.EmployeeSelary;

@Repository
public interface EmployeeSelaryRepository extends CrudRepository<EmployeeSelary, Integer> {

}
