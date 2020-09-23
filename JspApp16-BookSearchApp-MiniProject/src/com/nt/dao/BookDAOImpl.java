package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookBO;
import com.nt.utility.DBConnectionUtil;

public class BookDAOImpl implements IBookDAO {
	private static final String GET_BOOKS_BY_CATEGORY = "SELECT BOOKID,BOOKNAME,AUTHOR,PUBLISHER,PRICE,STATUS,CATEGORY  FROM BOOK_STORE WHERE CATEGORY=? ORDER BY BOOKNAME ";
	/*@Override
	public List<BookBO> findBooksByCategory(String category)throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		
	       //get Pooled jdbc con object
		con=DBConnectionUtil.getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		//set value to qyery params
		ps.setString(1,category);
		//send and execute SQL query
		rs=ps.executeQuery();
		//copy RS records to ArrayList
		listBO=new ArrayList();
		while(rs.next()) {
			//copy each record of RS to  One Object of BO class
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPublisher(rs.getString(4));
			bo.setPrice(rs.getFloat(5));
			bo.setStatus(rs.getString(6));
			bo.setCategory(rs.getString(7));
			//add each BO class object to  listBO
			listBO.add(bo);
		}//while
		return listBO;
	}//method
	*/

	/*@Override
	public List<BookBO> findBooksByCategory(String category)throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BookBO> listBO=null;
		BookBO bo=null;
		try {
	       //get Pooled jdbc con object
		con=DBConnectionUtil.getPooledConnection();
		//create PreparedStatement object
		ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);
		//set value to qyery params
		ps.setString(1,category);
		//send and execute SQL query
		rs=ps.executeQuery();
		//copy RS records to ArrayList
		listBO=new ArrayList();
		while(rs.next()) {
			//copy each record of RS to  One Object of BO class
			bo=new BookBO();
			bo.setBookId(rs.getInt(1));
			bo.setBookName(rs.getString(2));
			bo.setAuthor(rs.getString(3));
			bo.setPublisher(rs.getString(4));
			bo.setPrice(rs.getFloat(5));
			bo.setStatus(rs.getString(6));
			bo.setCategory(rs.getString(7));
			//add each BO class object to  listBO
			listBO.add(bo);
		}//while
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			throw se;  //exxeption re thowing
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return listBO;
	}//method
	*/

	@Override
	public List<BookBO> findBooksByCategory(String category) throws Exception {
		List<BookBO> listBO = null;
		BookBO bo = null;
		// get Pooled jdbc con object
		Connection con = DBConnectionUtil.getPooledConnection();
		try (con) { // 1 try with resource
			// create PreparedStatement object
			PreparedStatement ps = con.prepareStatement(GET_BOOKS_BY_CATEGORY);
			try (ps) {// 2 try with resource
				// set value to qyery params
				ps.setString(1, category);
				// send and execute SQL query
				ResultSet rs = ps.executeQuery();
				try (rs) { // 3 try with resource
					// copy RS records to ArrayList
					listBO = new ArrayList();
					while (rs.next()) {
						// copy each record of RS to One Object of BO class
						bo = new BookBO();
						bo.setBookId(rs.getInt(1));
						bo.setBookName(rs.getString(2));
						bo.setAuthor(rs.getString(3));
						bo.setPublisher(rs.getString(4));
						bo.setPrice(rs.getFloat(5));
						bo.setStatus(rs.getString(6));
						bo.setCategory(rs.getString(7));
						// add each BO class object to listBO
						listBO.add(bo);
					} // while
				} // try3
			} // try2
		} // try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se; // exxeption re thowing
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}// method

}// class
