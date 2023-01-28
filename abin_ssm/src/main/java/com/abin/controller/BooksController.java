package com.abin.controller;

import com.abin.pojo.Books;
import com.abin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

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

        String bookName = books.getBookName();
        List<Books> list = booksService.queryAllBooks();
        List<Books> collect = list.stream().filter(t -> t.getBookName().equals(bookName)).collect(Collectors.toList());
        if (collect.size() > 0){
            Books matchBook = collect.get(0);
            int bookCounts = matchBook.getBookCounts();
            bookCounts += books.getBookCounts();

            if (bookCounts <= 0){
                booksService.deleteBooks(books.getBookId());
            }else {
                books.setBookId(matchBook.getBookId());
                books.setBookCounts(bookCounts);

                booksService.updateBooks(books);
            }
        }else {
            booksService.addBooks(books);
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toUpdateBook(HttpServletRequest request,Model model){
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        int bookCounts = Integer.parseInt(request.getParameter("bookCounts"));
        String bookDesc = request.getParameter("bookDesc");
        Books books = new Books(bookId, bookName, bookCounts, bookDesc);
        model.addAttribute("books",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        int i = booksService.updateBooks(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(HttpServletRequest request){
        String id = request.getParameter("bookId");
        booksService.deleteBooks(Integer.parseInt(id));
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){

        System.out.println("要查询的书籍名称：" + queryBookName);
        List<Books> books = booksService.queryAllBooks();
        if (StringUtils.isEmpty(queryBookName)){
            model.addAttribute("list",books);
            return "allBook";
        }
        List<Books> list = books.stream().filter(t -> queryBookName.equals(t.getBookName())).collect(Collectors.toList());
        if (list.size() < 1){
            model.addAttribute("error","没有找到这本书！");
            return "allBook";
        }
        model.addAttribute("list",list);
        return "allBook";
    }
}
