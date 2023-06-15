package br.dev.techtalk.service;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.domain.enumeration.BookMemberEnum;
import br.dev.techtalk.repository.BookRepository;

import java.util.Arrays;
import java.util.List;

public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book findCustomById(Long id) {
        List<String> bookMembers = Arrays.asList(BookMemberEnum.BOOK.getValue());
        return bookRepository.findById(id, bookMembers);
    }

    public Book findCustomFetchById(Long id) {
        return bookRepository.findCustomFetchById(id);
    }

}
