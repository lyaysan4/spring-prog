package spring.prog.springprog.model;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    private Author author;

    protected Book() {
    }

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    /*public Book(String name, String authorName) {
        this.name = name;
        author.setName(authorName);
    }*/

    public static Book addNewBook(String name, String authorName) {
        Author author1 = new Author(authorName);
        return new Book(name, author1);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
