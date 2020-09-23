package com.nt.dao;

import java.util.List;

import com.nt.bo.BookBO;

public interface IBookDAO {
    public List<BookBO>  findBooksByCategory(String category)throws Exception;
}
