package com.jpasample.apicreation.Dao;

import org.springframework.data.repository.CrudRepository;

import com.jpasample.apicreation.Entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

    public Book findById(int id);

}
