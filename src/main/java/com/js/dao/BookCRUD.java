package com.js.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.js.dto.Book;

public class BookCRUD {
	 final String path="com.mysql.cj.jdbc.Driver";
	 final static String address="jdbc:mysql://localhost:3306/book_store?user=root&password=root";
	  static Connection c=null;
	public int insertBook(Book b)
	{
		
		
	try {
		Class.forName(path);
		c=DriverManager.getConnection(address);
		Statement s=c.createStatement();
		PreparedStatement ps =c.prepareStatement("insert into book values(?,?,?,?,?) ");
		ps.setInt(1, b.getBook_id());
		ps.setString(2, b.getBook_name());//set the values in the place holder
		ps.setString(3, b.getBook_author());
		ps.setInt(4,b.getNo_of_pages());
		ps.setDouble(5, b.getPrice());
		return ps.executeUpdate();
		
		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	return 0;
	
	}
	public int deletBook(int id)
	{
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c=DriverManager.getConnection(address);
			PreparedStatement ps =c.prepareStatement("delete from book where book_id=? ");
			ps.setInt(1, id);
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				c.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return 0;
		
	}
	public int upadatebook(int id,Book b)
	{
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c=DriverManager.getConnection(address);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    try {
			PreparedStatement ps =c.prepareStatement("update Book set book_name=?,book_author=? where book_id=? ");
			
			ps.setString(1, b.getBook_name());
			ps.setString(2, b.getBook_author());
			ps.setInt(3, id);
			return ps.executeUpdate();// return type is int value
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    finally
	    {
	    	try {
	    		c.close();
				
			} catch (Exception e2) {
			}
	    }
		return 0;
		
	}
	
public Book GetbookbyId(int id)
{
Book b=null;
try {
	Class.forName(path);
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
try {
	c=DriverManager.getConnection(address);
	PreparedStatement ps=c.prepareStatement("select * from book where book_id=?");
	ps.setInt(1, id);
  ResultSet rs= ps.executeQuery();
	if(rs.next())
	{
		b=new Book();
	b.setBook_id(rs.getInt(1));
    b.setBook_name(rs.getString(2));
    b.setBook_author(rs.getString(3));
    b.setNo_of_pages(rs.getInt(4));
	b.setPrice(rs.getDouble(5));
	return b;
	}
	else
	{
		return b;
	}
} catch (SQLException e) {

	e.printStackTrace();
}
finally
{
	try {
		c.close();
	} catch (Exception e2) {
	}
}
return b;




}
	public ArrayList<Book> getallBook()
	{
		ArrayList<Book> al=new ArrayList<Book>();
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement("select * from book");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			
			{
				Book b=new Book();
				b.setBook_id(rs.getInt(1));
				b.setBook_name(rs.getString(2));
				b.setBook_author(rs.getString(3));
				b.setNo_of_pages(rs.getInt(4));
				b.setPrice(rs.getDouble(5));
				al.add(b);
		      
			}
			return al;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				c.close();
			} catch (Exception e2) {
			}
		}
		return al;
		
	}
	public Boolean Batchexecution(ArrayList<Book>books)
	{
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			c=DriverManager.getConnection(address);
			PreparedStatement ps=c.prepareStatement(" insert into book values(?,?,?,?,?)");
	        for( Book b:books)
	        {
	        ps.setInt(1, b.getBook_id());
	        ps.setString(2,b.getBook_name());
	        ps.setString(3,b.getBook_author());
	        ps.setInt(4,b.getNo_of_pages());
	        ps.setDouble(5, b.getPrice());
	        ps.addBatch();
	        }
	         ps.executeBatch();
	         return true;
	        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			try {
				c.close();
			} catch (Exception e2) {
			}
		}
		return false;
		
		
	}
	

}