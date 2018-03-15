package com.sean.Book.controllers;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sean.Book.models.Books;
import com.sean.Book.services.BookService;

@Controller
public class HomeController {
	private final BookService bookService;
	
	public HomeController(BookService bookService) {
		this.bookService = bookService;
	}
	@RequestMapping("/books")
	public String book(Model model) {
		List<Books> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books";
					
	}
	@RequestMapping("/books/{index}")
	public String bookList(Model model, @PathVariable("index") int index) {
		Books book = bookService.findBookByIndex(index);
		model.addAttribute("books", book);
		return "bookslist";
					
	}
	@RequestMapping("/books/new")
	public String newBook(@ModelAttribute("books") Book book) {
		return "newBook";
	}
	@PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "newBook.jsp";
        }else{
            bookService.addBook(book);
            return "redirect:/books";
        }
    }
	@RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Books book = bookService.findBookByIndex(id);
        if (book != null){
            model.addAttribute("book", book);
            return "editBook";
        }else{
            return "redirect:/books";
        }
    }
	@RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") int id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }

}
