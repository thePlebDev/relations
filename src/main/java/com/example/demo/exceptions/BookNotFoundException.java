package com.example.demo.exceptions;

import java.text.MessageFormat;

public class BookNotFoundException extends RuntimeException{
	
	public BookNotFoundException( int id) {
		super(MessageFormat.format("book {0} not found", id));
	}

}
