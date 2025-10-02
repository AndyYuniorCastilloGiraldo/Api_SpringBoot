package com.dominar01.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominar01.demo.Service.BookService;
import com.dominar01.demo.model.Book;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/Book")
@RequiredArgsConstructor
public class BookController {

	private final BookService service;


	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		//service = new BookServiceImpl();
		List<Book> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook( @PathVariable ("id") Integer id) {
		//service = new BookServiceImpl();
		Book book = service.findById(id);
		return ResponseEntity.ok(book);
	}
	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book books) {
		Book newBook = service.guardar(books);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook( @PathVariable("id") Integer id, @RequestBody Book books) {
		Book newBook = service.actualizar(id, books);
		return ResponseEntity.ok(newBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook( @PathVariable ("id") Integer id) {
		//service = new BookServiceImpl();
		service.delete(id);
		return ResponseEntity.noContent().build();
	}












	//private String text;
	
	/*public BookController(BookService service) {
		this.service = service;
	}

	@GetMapping
	public Book getBook() {
		//service = new BookServiceImpl();
		return service.validAndReturnBook(1);
	}*/

}
