package br.dev.techtalk.infra.repository.jpa;

import br.dev.techtalk.infra.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaBookGraphRepository extends JpaRepository<BookEntity, Long> {

    @Override
    @EntityGraph(value = "bookAllNodes")
    List<BookEntity> findAll();

    @Override
    @EntityGraph(value = "bookAllNodes")
    Optional<BookEntity> findById(Long id);

}
