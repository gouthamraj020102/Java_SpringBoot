package com.jpasample.apicreation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpasample.apicreation.Dao.BookRepository;
import com.jpasample.apicreation.Entities.Book;

@Service // (or) @Component
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// get all books
	public List<Book> getallBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}

	// get single book by Id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// adding a book
	public Book addBook(Book book) {
		Book result = bookRepository.save(book);
		return result;
	}

	// deleting a book
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}

	// updating a book
	public void updateBook(Book book, int id) {
		book.setId(id);
		bookRepository.save(book);
	}

}
