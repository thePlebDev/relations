package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Book;
import com.example.demo.models.Library;
import com.example.demo.services.BookService;
import com.example.demo.services.LibraryService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	private final BookService bookService;
	private final LibraryService libraryService;
	
	@Autowired
	public BookController(BookService bookService,LibraryService libraryService) {
		this.bookService = bookService;
		this.libraryService = libraryService;
	}
	
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}
	
	@PutMapping("{libraryId}/{bookId}")
	public Book addToLibrary(@PathVariable int libraryId,@PathVariable int bookId) {

		Library library = libraryService.getLibrary(libraryId);
		Book book = bookService.findBook(bookId);
		
		libraryService.addBook(library, book);
		return bookService.setLibrary(library, bookId);
		
	}

}
