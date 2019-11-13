package com.adjava;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Book {
 
	@Id
	
	int id;
	String bookname;
	int bookqntity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getBookqntity() {
		return bookqntity;
	}
	public void setBookqntity(int bookqntity) {
		this.bookqntity = bookqntity;
	}
	
	
}
