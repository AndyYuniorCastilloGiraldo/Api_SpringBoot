package com.dominar01.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dominar01.demo.Service.BookService;
import com.dominar01.demo.model.Book;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/Book")

public class BookController {

	@Autowired
	private BookService service;

	@GetMapping
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") Integer id) {
		Book book = service.findById(id);
		return ResponseEntity.ok(book);
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book books) {
		Book newBook = service.guardar(books);
		return ResponseEntity.status(HttpStatus.CREATED).body(newBook);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book books) {
		Book newBook = service.actualizar(id, books);
		return ResponseEntity.ok(newBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") Integer id) {
		// service = new BookServiceImpl();
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) {
		Book book = service.BUscarPorTitulo(title);
		return ResponseEntity.ok(book);
	}

	@GetMapping("/count/{author}")
	public ResponseEntity<Integer> contarPorAutor(@PathVariable String author) {
		int cantidad = service.contarPorAutor(author);
		return ResponseEntity.ok(cantidad);
	}

	@GetMapping("/listTop10")
	public List<Book> getTop10Books() {
		return service.getTop10Books();
	
}
}
