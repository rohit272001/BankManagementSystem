package com.fis.bankmanagementspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.fis.bankmanagementspring.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
