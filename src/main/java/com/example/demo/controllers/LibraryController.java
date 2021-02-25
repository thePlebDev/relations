package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exceptions.LibraryNotFoundException;
import com.example.demo.models.Library;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.LibraryRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.LibraryService;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController {
	private final LibraryService libraryService;
	private final BookService bookService;
	
	@Autowired
	public LibraryController(LibraryService libraryService,BookService bookService) {
		this.libraryService = libraryService;
		this.bookService = bookService;
	}
	
	@GetMapping("{id}")
	public Library getLibrary(@PathVariable int id) {
		return libraryService.getLibrary(id);
	}
	
	@PostMapping
	public Library saveLibrary(@RequestBody Library library) {
		return libraryService.addLibrary(library);
	}
	@DeleteMapping("{id}")
	public Library deleteLibrary(@PathVariable int id) {
		return libraryService.deleteLibrary(id);
	}
	@PutMapping("{id}")
	public Library editLibrary(@PathVariable int id,
							   @RequestBody Library library) {
		return libraryService.editLibrary(id, library);
	}
	

}
