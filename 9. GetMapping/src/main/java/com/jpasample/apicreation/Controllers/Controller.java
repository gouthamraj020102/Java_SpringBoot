package com.jpasample.apicreation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpasample.apicreation.Entities.Book;
import com.jpasample.apicreation.Services.BookService;

@RestController
public class Controller {

	@Autowired
	BookService bookservice;
	
	    @GetMapping("/books")
	    public List<Book> getallbooks() {
	        return this.bookservice.getallBooks();
	    }
	    
	    @GetMapping("/books/{id}")
	    public Book getBookById(@PathVariable("id") int id) {
	        return bookservice.getBookById(id);
	    }


}
