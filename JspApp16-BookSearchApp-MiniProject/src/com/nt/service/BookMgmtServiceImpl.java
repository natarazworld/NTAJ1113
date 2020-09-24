package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.dao.BookDAOImpl;
import com.nt.dao.IBookDAO;
import com.nt.dto.BookDTO;

public class BookMgmtServiceImpl implements IBookMgmtService {
	private IBookDAO dao;
	public BookMgmtServiceImpl() {
		  dao=new BookDAOImpl(); //only one object
	}

	@Override
	public List<BookDTO> searchBooksByCategory(String category) throws Exception {
		List<BookBO> listBO=null;
		List<BookDTO> listDTO=new ArrayList();
		
		//use dAO
		listBO=dao.findBooksByCategory(category);
		//convert listBO to listDTO
		listBO.forEach(bo->{
			//convert each bo to each dto
			BookDTO dto=new BookDTO();
			dto.setBookId(bo.getBookId());
			dto.setBookName(bo.getBookName());
			dto.setAuthor(bo.getAuthor());
			dto.setCategory(bo.getCategory());
			dto.setPrice(bo.getPrice());
			dto.setStatus(bo.getStatus());
			dto.setPublisher(bo.getPublisher());
			dto.setSerialNo(listDTO.size()+1);
			//add  each dto to ListDTO
			listDTO.add(dto);
		});
		
		return listDTO;
	}//method
}//class
