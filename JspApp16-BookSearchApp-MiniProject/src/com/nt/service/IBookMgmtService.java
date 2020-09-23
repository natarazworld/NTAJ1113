package com.nt.service;

import java.util.List;

import com.nt.dto.BookDTO;

public interface IBookMgmtService {
    public   List<BookDTO>  searchBooksByCategory(String category)throws Exception;
}
