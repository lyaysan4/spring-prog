package spring.prog.springprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.prog.springprog.model.Author;
import spring.prog.springprog.model.Book;
import spring.prog.springprog.repository.AuthorRepository;
import spring.prog.springprog.repository.BookRepository;

import java.util.concurrent.ArrayBlockingQueue;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping("/books")
    public String showBookByName(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("books", bookRepository.findByNameLikeIgnoreCase("%" + name + "%"));
        return "books";
    }

    @RequestMapping("/books/edit")
    public String edit() {
        return "edit";
    }

    @PostMapping("/books/edit")
    public String addBook(@RequestParam(value = "name") String name, @RequestParam(value = "author", required = false, defaultValue = "Неизвестно") String author, Model model) {

        Author author1 = authorRepository.findByNameLikeIgnoreCase("%" + author + "%");
        if (author1!=null) {
            if (!bookRepository.findByNameLikeIgnoreCase("%" + name + "%").isEmpty()) {
                String notif = "Эта книга уже есть.";
                model.addAttribute("notif", notif);
                return "edit";
            } else {
                Book addedBook = new Book(name, author1);
                author1.setBook(addedBook);
                bookRepository.save(addedBook);
                String notif = "Книга \"" + addedBook.getName() + "\", написанная " + addedBook.getAuthor() + " успешно добавлена!";
                model.addAttribute("books", addedBook);
                model.addAttribute("notif", notif);
                return "edit";
            }
        } else {
            Author author2 = new Author(author);
            Book addedBook = new Book(name, author2);
            authorRepository.save(author2);
            bookRepository.save(addedBook);
            String notif = "Книга \"" + addedBook.getName() + "\", написанная " + addedBook.getAuthor() + " успешно добавлена!";
            model.addAttribute("books", addedBook);
            model.addAttribute("notif", notif);
            return "edit";
        }

    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}