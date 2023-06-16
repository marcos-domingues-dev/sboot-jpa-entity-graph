package br.dev.techtalk.infra.repository.jpa;

import br.dev.techtalk.infra.repository.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookRepository extends JpaRepository<BookEntity, Long> {
}
