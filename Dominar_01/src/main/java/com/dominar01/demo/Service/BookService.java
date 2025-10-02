package com.dominar01.demo.Service;

import java.util.List;

import com.dominar01.demo.model.Book;

public interface BookService {
    
    //Book validAndReturnBook(int id);
    Book guardar(Book book);
    Book actualizar(Integer id, Book book);
    List<Book> findAll();
    Book findById(Integer id);
    void delete(Integer id);
}
