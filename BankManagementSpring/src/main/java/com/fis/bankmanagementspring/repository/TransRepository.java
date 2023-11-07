package com.fis.bankmanagementspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankmanagementspring.model.Trans;

public interface TransRepository extends CrudRepository<Trans, Integer> {

}
