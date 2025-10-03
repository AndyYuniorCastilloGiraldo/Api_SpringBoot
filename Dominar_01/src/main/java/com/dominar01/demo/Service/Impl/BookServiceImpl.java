package com.dominar01.demo.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominar01.demo.Service.BookService;
import com.dominar01.demo.model.Book;
import com.dominar01.demo.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo repo;

    @Override
    public Book guardar(Book book) {
        return repo.save(book);
    }

    @Override
    public Book actualizar(Integer id, Book book) {
        book.setIdBook(id);
       return repo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return repo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Book BUscarPorTitulo(String title) {
        return repo.findByTitle(title);
    }

    @Override
    public int contarPorAutor(String author) {
        return repo.countByAuthor(author);
    }
    
}
