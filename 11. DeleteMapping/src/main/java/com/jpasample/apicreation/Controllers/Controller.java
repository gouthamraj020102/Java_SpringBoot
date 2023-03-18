package com.jpasample.apicreation.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpasample.apicreation.Entities.Book;
import com.jpasample.apicreation.Services.BookService;

@RestController
public class Controller {

	@Autowired
	BookService bookservice;

	// get all books handler
	@GetMapping("/books")
	public List<Book> getallbooks() {
		return this.bookservice.getallBooks();
	}

	// get single book handler
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookservice.getBookById(id);
	}

	// new book handler
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservice.addBook(book);
		System.out.println(b);
		return b;
	}

	// delete book handler
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId);
	}
}

// NOTE:
// If you run into issues in post endpoint, make sure to enter JSON data in
// Body->raw
// If you got plain text issue then refer you this Link:
// https://stackoverflow.com/questions/24972437/error-org-springframework-web-httpmediatypenotsupportedexception-content-type
/*
 * Sample Json data
 * {
 * "id": 4,
 * "name": "React",
 * "author": "Jordan Walke"
 * }
 */