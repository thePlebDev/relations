package com.example.demo.exceptions;

import java.text.MessageFormat;

public class LibraryNotFoundException extends RuntimeException{
	
	public LibraryNotFoundException(int id) {
		super(MessageFormat.format("library {0} not found",id ));
	}

}
