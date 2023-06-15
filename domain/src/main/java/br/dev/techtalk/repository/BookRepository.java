package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findAll();

    Book findById(Long id);

    Book findById(Long id, List<String> bookMembers);

    void save(Book book);

    Book findCustomFetchById(Long id);
}
