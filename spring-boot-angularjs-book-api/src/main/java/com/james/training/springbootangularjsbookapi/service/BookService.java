package com.james.training.springbootangularjsbookapi.service;

import java.util.List;

import com.james.training.springbootangularjsbookapi.entity.Book;

public interface BookService {
	// save book
	void save(Book book);

	// get single book
	Book getBook(int id);

	// get list of books
	List<Book> getBookList();

	// delete book
	void deleteBook(int id);
}
