package com.jpasample.apicreation.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpasample.apicreation.Entities.Book;

@Service // (or) @Component
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(1, "Flowchart", "Unknown author"));
		list.add(new Book(2, "C Language", "Dennis Ritchie"));
		list.add(new Book(3, "Java", "James Gosling"));
	}

	// get all books
	public List<Book> getallBooks() {
		return list;
	}

	// get single book by Id
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// adding a book
	public Book addBook(Book book) {
		list.add(book);
		return book;
	}

	// deleting a book
	public void deleteBook(int id) {
		list = list.stream().filter(book -> book.getId() != id).collect(Collectors.toList());
	}

	// updating a book
	public void updateBook(Book book, int id) {
		list = list.stream().map(e -> {
			if (e.getId() == id) {
				e.setName(book.getName());
				e.setAuthor(book.getAuthor());
			}
			return e;
		}).collect(Collectors.toList());
	}

}
