package com.example.demo.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Library {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	private String name;
	
	@OneToMany(mappedBy = "library", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Book> books = new ArrayList<Book>();
	
	public Library () {}
	public Library(String name) {
		this.name = name;
	}
	
	//GETTERS AND SETTERS
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Book> addBook(Book book){
		books.add(book);
		return books;
	}
}
