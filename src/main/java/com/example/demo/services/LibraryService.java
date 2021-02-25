package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.LibraryNotFoundException;
import com.example.demo.models.Library;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.LibraryRepository;

@Service
public class LibraryService {
	private final LibraryRepository libraryRepository;
	private final BookRepository bookRepository;
	
	@Autowired
	public LibraryService(LibraryRepository libraryRepository,BookRepository bookRepository) {
		this.bookRepository = bookRepository;
		this.libraryRepository = libraryRepository;
	}
	
	public Library addLibrary(Library library) {
		return libraryRepository.save(library);
	}
	
	public Library getLibrary(int id) {
		return libraryRepository.findById(id)
				.orElseThrow(()-> new LibraryNotFoundException(id));
	}
	
	public Library deleteLibrary(int id) {
		Library libraryToDelete = getLibrary(id);
	    libraryRepository.delete(libraryToDelete);
	    return libraryToDelete;
	}
	public Library editLibrary(int id, Library library) {
		Library libraryToEdit = getLibrary(id);
		libraryToEdit.setName(library.getName());
		libraryRepository.save(libraryToEdit);
		return libraryToEdit;
	}

}
