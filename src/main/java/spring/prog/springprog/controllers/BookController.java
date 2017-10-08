package spring.prog.springprog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.prog.springprog.repository.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public String showBookByName(@RequestParam(value = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("books", bookRepository.findByNameLike("%" + name.toLowerCase() + "%"));
        return "books";
    }
}