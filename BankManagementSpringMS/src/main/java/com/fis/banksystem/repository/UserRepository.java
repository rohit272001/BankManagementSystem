package com.fis.banksystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.fis.banksystem.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
