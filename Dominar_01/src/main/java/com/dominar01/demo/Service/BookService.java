package com.dominar01.demo.Service;

import java.util.List;

import com.dominar01.demo.model.Book;
//import com.dominar01.demo.repository.BookRepo;

public interface BookService  {
    
    
    Book guardar(Book book);
    Book actualizar(Integer id, Book book);
    List<Book> findAll();
    Book findById(Integer id);
    void delete(Integer id);
    Book BUscarPorTitulo(String title);
}
