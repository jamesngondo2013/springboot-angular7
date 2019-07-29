package com.james.training.springbootangularjsbookapi.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.james.training.springbootangularjsbookapi.entity.Book;



@Repository
public class BookDAOImpl implements BookDAO{

	//define field for entityManager
		private EntityManager entityManager;
		
		//set up constructor injection - can use any type of injection eg method
		public BookDAOImpl(EntityManager entityManager) {
			this.entityManager = entityManager;
		}	
		
	@Override
	public void save(Book book) {
		// get the hibernate session - import
		Session currentSession = entityManager.unwrap(Session.class);

		// save customer
		currentSession.saveOrUpdate(book);
	
	}

	@Override
	public Book getBook(int id) {
		// get the hibernate session - import
		Session currentSession = entityManager.unwrap(Session.class);

		Book book = currentSession.get(Book.class, id);

		return book;
	}

	@Override
	public List<Book> getBookList() {

		// get the hibernate session - import
		Session currentSession = entityManager.unwrap(Session.class);

		// create query
		Query<Book> theQuery = currentSession.createQuery("from Book", Book.class);

		// execute query and get result list
		List<Book> books = theQuery.getResultList();

		// return the results
		return books;
	}


	@Override
	public void deleteBook(int id) {

		// get the hibernate session - import
		Session currentSession = entityManager.unwrap(Session.class);

		Query theQuery = currentSession.createQuery("delete from Book where id=:bookId");

		theQuery.setParameter("bookId", id);

		theQuery.executeUpdate();

	}
}
