package com.fis.banksystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.fis.banksystem.model.Trans;

public interface TransRepository extends CrudRepository<Trans, Integer> {

}
