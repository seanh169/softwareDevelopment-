package com.simpleapp.spring5simplewebapp.bootstrap;

import com.simpleapp.spring5simplewebapp.domain.Author;
import com.simpleapp.spring5simplewebapp.domain.Book;
import com.simpleapp.spring5simplewebapp.domain.Publisher;
import com.simpleapp.spring5simplewebapp.repositories.AuthorRepository;
import com.simpleapp.spring5simplewebapp.repositories.BookRepository;
import com.simpleapp.spring5simplewebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher john = new Publisher("John", "123 Elm Street", "Baltimore", "MD", "21045");
        publisherRepository.save(john);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(john);
        john.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);



        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

//        ddd.setPublisher();
        noEJB.setPublisher(john);
        john.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(john);







        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Publisher John num of books : " + john.getBooks().size());

    }
}
