package spring.prog.springprog.repository;

import org.springframework.data.repository.CrudRepository;
import spring.prog.springprog.model.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByAuthorName(String authorName);

    List<Book> findByNameLike(String name);
}
