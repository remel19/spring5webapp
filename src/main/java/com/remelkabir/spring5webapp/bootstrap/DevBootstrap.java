package com.remelkabir.spring5webapp.bootstrap;

import com.remelkabir.spring5webapp.model.Author;
import com.remelkabir.spring5webapp.model.Book;
import com.remelkabir.spring5webapp.model.Publisher;
import com.remelkabir.spring5webapp.repositories.AuthorRepository;
import com.remelkabir.spring5webapp.repositories.BookRepository;
import com.remelkabir.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Evans");
        Author rod = new Author("Rod", "Johnson");

        Publisher scholastic = new Publisher("Scholastic");
        Publisher bloomsbury = new Publisher("Bloomsbury Publishing");
        publisherRepository.save(scholastic);
        publisherRepository.save(bloomsbury);


        Book ddd = new Book("Domain Driven Design", "1234", scholastic);
        Book noEJB = new Book("J2EE Development without EJB", "12345", bloomsbury);
        Book remel = new Book("awesome life of Remel", "123455", scholastic);

        eric.getBooks().add(ddd);
        rod.getBooks().add(noEJB);

        authorRepository.save(eric);
        authorRepository.save(rod);

        ddd.getAuthors().add(eric);
        noEJB.getAuthors().add(rod);
        remel.getAuthors().add(eric);

        bookRepository.save(ddd);
        bookRepository.save(noEJB);
        bookRepository.save(remel);
    }

}
