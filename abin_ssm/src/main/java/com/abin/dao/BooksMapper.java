package com.abin.dao;

import com.abin.pojo.Books;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksMapper {

    int addBooks(Books books);

    int deleteBooks(int id);

    int updateBooks(Books books);

    List<Books> queryAllBooks();

    Books queryBooks(int id);

}
