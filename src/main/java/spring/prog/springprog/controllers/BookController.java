package spring.prog.springprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring.prog.springprog.model.Author;
import spring.prog.springprog.model.Book;
import spring.prog.springprog.repository.AuthorRepository;
import spring.prog.springprog.repository.BookRepository;

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
    public String addBook(@RequestParam(value = "name") String name,
                          @RequestParam(value = "author", required = false, defaultValue = "Неизвестно") String authorName,
                          Model model) {
        Author author = authorRepository.findByNameLikeIgnoreCase("%" + authorName + "%");
        if (author != null) {
            if (!bookRepository.findByNameLikeIgnoreCaseAndAuthor("%" + name + "%", author).isEmpty()) {
                String notif = "Эта книга уже есть.";
                model.addAttribute("notif", notif);
                return "edit";
            }
        } else
            author = authorRepository.save(new Author(authorName));

        Book addedBook = new Book(name, author);
        bookRepository.save(addedBook);
        String notif = "Книга \"" + addedBook.getName() + "\", написанная " + addedBook.getAuthor() + " успешно добавлена!";
        model.addAttribute("books", addedBook);
        model.addAttribute("notif", notif);
        return "edit";
    }

    @PostMapping("/books/delete")
    public String deleteBook(@RequestParam(value = "id") Long id) {
        bookRepository.delete(id);
        return "redirect:/books";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}