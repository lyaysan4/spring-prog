package spring.prog.springprog.repository;

import org.springframework.data.repository.CrudRepository;
import spring.prog.springprog.model.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {

   // List<Author> findAuthorByNameLike(String authorName);

    Author findByNameLikeIgnoreCase(String authorName);
}
