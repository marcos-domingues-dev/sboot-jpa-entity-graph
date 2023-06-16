package br.dev.techtalk.infra.repository;

import br.dev.techtalk.domain.Publisher;
import br.dev.techtalk.infra.repository.entity.PublisherEntity;
import br.dev.techtalk.infra.repository.jpa.JpaAuthorRepository;
import br.dev.techtalk.infra.repository.jpa.JpaPublisherRepository;
import br.dev.techtalk.mapper.PublisherMapper;
import br.dev.techtalk.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PublisherRepositoryImpl implements PublisherRepository {

    @Autowired
    private JpaPublisherRepository jpaPublisherRepository;

    @Autowired
    PublisherMapper publisherMapper;

    @Autowired
    private JpaAuthorRepository jpaAuthorRepository;

    @Override
    public Publisher findById(Long id) {
        Optional<PublisherEntity> optionalEntity = jpaPublisherRepository.findById(id);
        return publisherMapper.toDomain(optionalEntity.get());
    }

    @Override
    public Publisher findByName(String name) {
        List<PublisherEntity> findResult = jpaPublisherRepository.findByName(name);
        if (!findResult.isEmpty()) {
            return publisherMapper.toDomain(findResult.get(0));
        }
        return null;
    }

    @Override
    @Transactional
    public void save(Publisher publisher) {
        PublisherEntity entity = publisherMapper.toEntity(publisher);
        jpaPublisherRepository.save(entity);
    }

}
