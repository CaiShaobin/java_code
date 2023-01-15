package com.abin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    int bookId;
    String bookName;
    int bookCounts;
    String bookDesc;

}
