package com.abin.pojo;

public class Books {

    int bookId;
    String bookName;
    int bookCounts;
    String bookDesc;

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookCounts=" + bookCounts +
                ", bookDesc='" + bookDesc + '\'' +
                '}';
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookCounts() {
        return bookCounts;
    }

    public void setBookCounts(int bookCounts) {
        this.bookCounts = bookCounts;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public Books(int bookId, String bookName, int bookCounts, String bookDesc) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookCounts = bookCounts;
        this.bookDesc = bookDesc;
    }

    public Books() {
    }
}
