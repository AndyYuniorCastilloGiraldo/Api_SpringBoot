package com.dominar01.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.dominar01.demo.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {
    /*Con Spring Data JPA no necesitas un BookRepoImpl porque:
Reconoce los métodos personalizados automáticamente
Cuando declaras Book findByTitle(String title), Spring interpreta que quieres buscar en la columna title de la tabla book.
Tú solo declaras el método, no escribes SQL ni lógica manual.
Genera la implementación interna (“clase oculta”)
Spring crea por detrás una clase que implementa BookRepo.
Esa clase sabe cómo conectarse a la base de datos y ejecutar la consulta equivalente a:
SELECT * FROM book WHERE title = ?; */
    Book findByTitle(String title);

    
}
