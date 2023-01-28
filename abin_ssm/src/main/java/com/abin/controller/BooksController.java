package com.abin.controller;

import com.abin.pojo.Books;
import com.abin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {

    @Autowired
    @Qualifier("booksService")
    BooksService booksService;

    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = booksService.queryAllBooks();
        model.addAttribute("list",books);
        return "allBook";
    }

    @RequestMapping("/addBook")
    public String add(Books books,Model model){
        int i = booksService.addBooks(books);

        return "redirect:/book/allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }
}
