package com.james.training.springbootangularjsbookapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.james.training.springbootangularjsbookapi.dao.BookDAOImpl;
import com.james.training.springbootangularjsbookapi.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	
	@Autowired
	private BookDAOImpl bookDAO;
	
	@Override
	@Transactional
	public void save(Book book) {
		
		bookDAO.save(book);
	
	}

	@Override
	@Transactional
	public Book getBook(int id) {
		
		
		return bookDAO.getBook(id);
	}

	@Override
	@Transactional
	public List<Book> getBookList() {
		
		return bookDAO.getBookList();
	}


	@Override
	@Transactional
	public void deleteBook(int id) {
		
		bookDAO.deleteBook(id);

	}

}
