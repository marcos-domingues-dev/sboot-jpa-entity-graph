package br.dev.techtalk.service;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.repository.BookRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book findById(Long id, List<String> bookNodes) {
        return bookRepository.findById(id, bookNodes);
    }

    public Book findCustomFetchById(Long id) {
        return bookRepository.findCustomFetchById(id);
    }

}
