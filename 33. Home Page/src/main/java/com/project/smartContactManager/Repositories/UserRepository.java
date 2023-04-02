package com.project.smartContactManager.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.smartContactManager.Entities.User;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

}
