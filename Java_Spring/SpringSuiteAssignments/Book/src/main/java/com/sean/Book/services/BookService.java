package com.sean.Book.services;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.sean.Book.models.Books;

@Service
public class BookService {
	List<Books> books = new ArrayList<Books>(Arrays.asList(
			new Books("The MANE", "About a war", "Greek", 302),
			new Books("The Republic", "About a city", "Greek", 200),
			new Books("How to Read a book", "About reading books", "English", 200)));
	 public void addBook(@Valid Book book) {
	        books.add(book);
	    }
	 public void updateBook(int id, Books book) {
	        if (id < books.size()){
	            books.set(id, book);
	        }
	 }
	 public void destroyBook(int id) {
	        if (id < books.size()){
	            books.remove(id);
	        }
	    }
	public List<Books> allBooks(){
		return books;
	}
	public Books findBookByIndex(int index) {
		if (index < books.size()) {
			return books.get(index);
			}else {
				return null;
			}
	}
	
	
}
