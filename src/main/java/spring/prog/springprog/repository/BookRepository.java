package spring.prog.springprog.repository;

import org.springframework.data.repository.CrudRepository;
import spring.prog.springprog.model.Author;
import spring.prog.springprog.model.Book;

import java.util.List;

import static javafx.scene.input.KeyCode.T;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthorName(String authorName);

    List<Book> findByNameLikeIgnoreCase(String name);

    Book save(Book entity);
}