package br.dev.techtalk.infra.repository.jpa;

import br.dev.techtalk.infra.repository.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPublisherRepository extends JpaRepository<PublisherEntity, Long> {
    List<PublisherEntity> findByName(String name);
}
