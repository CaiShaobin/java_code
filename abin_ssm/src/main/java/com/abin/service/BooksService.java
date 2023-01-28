package com.abin.service;

import com.abin.pojo.Books;

import java.util.List;

public interface BooksService {

    int addBooks(Books books);

    int deleteBooks(int id);

    int updateBooks(Books books);

    List<Books> queryAllBooks();

    Books queryBooks(int id);
}
