package br.dev.techtalk.infra.repository;

import br.dev.techtalk.domain.Author;
import br.dev.techtalk.infra.repository.entity.AuthorEntity;
import br.dev.techtalk.infra.repository.jpa.JpaAuthorRepository;
import br.dev.techtalk.mapper.AuthorMapper;
import br.dev.techtalk.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository {

    @Autowired
    private JpaAuthorRepository jpaAuthorRepository;

    @Autowired
    AuthorMapper authorMapper;

    @Override
    public Author findById(Long id) {
        Optional<AuthorEntity> optionalEntity = jpaAuthorRepository.findById(id);
        return authorMapper.toDomain(optionalEntity.get());
    }

    @Override
    public Author findByName(String name) {
        List<AuthorEntity> findResult = jpaAuthorRepository.findByName(name);
        if (!findResult.isEmpty()) {
            return authorMapper.toDomain(findResult.get(0));
        }
        return null;
    }

    @Override
    @Transactional
    public void save(Author author) {
        AuthorEntity entity = authorMapper.toEntity(author);
        jpaAuthorRepository.save(entity);
    }

}
