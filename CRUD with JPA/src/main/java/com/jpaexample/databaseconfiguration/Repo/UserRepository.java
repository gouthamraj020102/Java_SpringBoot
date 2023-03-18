package com.jpaexample.databaseconfiguration.Repo;

import org.springframework.data.repository.CrudRepository;

import com.jpaexample.databaseconfiguration.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
