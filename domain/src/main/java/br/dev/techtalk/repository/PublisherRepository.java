package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Publisher;

public interface PublisherRepository {

    Publisher findById(Long id);

    Publisher findByName(String name);

    void save(Publisher publisher);
}
