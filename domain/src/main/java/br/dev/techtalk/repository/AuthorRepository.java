package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Author;

public interface AuthorRepository {

    Author findById(Long id);

    Author findByName(String name);

    void save(Author author);

}
