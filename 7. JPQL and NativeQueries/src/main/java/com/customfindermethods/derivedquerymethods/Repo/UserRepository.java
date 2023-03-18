package com.customfindermethods.derivedquerymethods.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.customfindermethods.derivedquerymethods.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	// JPQL = Java Persistent Query Language
	@Query("SELECT u FROM User u")
	public List<User> getallUsers();

	@Query("SELECT u FROM User u WHERE u.name = :n")
	public List<User> getUserByName(@Param("n") String name);

	@Query("SELECT u FROM User u WHERE u.name = :n AND u.city = :c")
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

	// Native Query
	@Query(value = "SELECT * FROM User u", nativeQuery = true)
	public List<User> getUsers();

}
