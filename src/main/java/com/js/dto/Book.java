package com.js.dto;

public class Book {
	private int book_id;
	 private String book_name;
	private String book_author;
     private int no_of_pages;
     private double price;
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public int getNo_of_pages() {
		return no_of_pages;
	}
	public void setNo_of_pages(int no_of_pages) {
		this.no_of_pages = no_of_pages;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", book_author=" + book_author
				+ ", no_of_pages=" + no_of_pages + ", price=" + price + "]";
	}
     
}
