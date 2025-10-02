package com.dominar01.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dominar01.demo.model.Book;
import com.dominar01.demo.model.Category;
import com.dominar01.demo.repository.BookRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepo repo;

    @Override
    public Book guardar(Book book) {
        // TODO Auto-generated method stub
       return repo.save(book);
    }

    @Override
    public Book actualizar(Integer id, Book book) {
        // TODO Auto-generated method stub
        book.setIdBook(id);
        return repo.save(book);
    }

    @Override
    public List<Book> findAll() {
        // TODO Auto-generated method stub
        return repo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        // TODO Auto-generated method stub
        return repo.findById(id).orElse(new Book(999,"NO BOOK",new Category(999, "NO CATEGORY"),false));
    }

    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        repo.deleteById(id);
    }

    /*public BookServiceImpl(BookRepo repo) {
        this.repo = repo;
    }
    @Override
    public Book validAndReturnBook(int id) {
        //repo = new BookRepoImpl();
        if (id > 0) {
            return repo.getBookById(id);
        } else {
            return new Book(0, "No existe el libro", false);
        }
    }
*/
}
