package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book findBook(int id) {
		return bookRepository.findById(id)
				.orElseThrow(()->new BookNotFoundException(id));
	}
	
	public Book setLibrary(Library library, int id) {
		Book book = findBook(id);
		book.setLibrary(library);
		bookRepository.save(book);
		return book;
	}

}
