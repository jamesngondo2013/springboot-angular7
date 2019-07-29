package com.james.training.springbootangularjsbookapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.training.springbootangularjsbookapi.entity.Book;
import com.james.training.springbootangularjsbookapi.service.BookService;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//http://localhost:9095/book/books
	/*create book
	{
        "title": "Business Mgt",
        "author": "Bright Banda"
	}
	*/
	
	//get all the books
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/books")
	public ResponseEntity<List<Book>> list(){
		
		List<Book> list = bookService.getBookList();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	//
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/books")
	public ResponseEntity<?> save(@RequestBody Book book){
		
		bookService.save(book);
		
		return ResponseEntity.ok().body("Book saved/updated");
		
	}
	
	//http://localhost:9095/book/books/4
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId){
		
		Book book = bookService.getBook(bookId);
		
		if (book == null) {
			
			//throw new CustomerNotFoundException("Customer ID " + customerId + " not found");
		}
		
		return bookService.getBook(bookId);
		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId){
		
		Book book = bookService.getBook(bookId);
		
		if (book == null) {
			
			//throw new CustomerNotFoundException("Customer ID " + customerId + " not found");
		}
		
		bookService.deleteBook(bookId);
		
		return "Book: " + bookId + " successfully deleted...!!!";
		
	}
	
}
