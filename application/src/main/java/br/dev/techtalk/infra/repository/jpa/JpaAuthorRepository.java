package br.dev.techtalk.infra.repository.jpa;

import br.dev.techtalk.infra.repository.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaAuthorRepository extends JpaRepository<AuthorEntity, Long> {
    List<AuthorEntity> findByName(String name);
}
