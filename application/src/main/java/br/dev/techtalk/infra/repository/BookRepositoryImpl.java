package br.dev.techtalk.infra.repository;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.infra.repository.entity.BookEntity;
import br.dev.techtalk.infra.repository.jpa.JpaBookRepository;
import br.dev.techtalk.mapper.BookMapper;
import br.dev.techtalk.mapper.CustomBookMapper;
import br.dev.techtalk.repository.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JpaBookRepository jpaBookRepository;
    @Autowired
    private BookMapper bookMapper;

    @Autowired
    CustomBookMapper customBookMapper;

    @Override
    public List<Book> findAll() {
        List<BookEntity> bookEntities = jpaBookRepository.findAll();
        return bookEntities.stream()
                .map(b -> bookMapper.toDomain(b))
                .collect(Collectors.toList());
    }

    @Override
    public Book findById(Long id) {
        Optional<BookEntity> optionalBookEntity = jpaBookRepository.findById(id);
        return bookMapper.toDomain(optionalBookEntity.get());
    }

    @Override
    public Book findById(Long id, List<String> bookNodes) {
        Optional<BookEntity> optionalBookEntity = jpaBookRepository.findById(id);
        return customBookMapper.bookMapperWithCustomNodes(optionalBookEntity.get(), bookNodes);
    }

    @Override
    public Book findCustomFetchById(Long id) {
        BookEntity bookEntity = entityManager.createQuery("""
                        select b
                        from book b
                        left join fetch b.publisher
                        left join fetch b.authors
                        where b.id = :id
                        """, BookEntity.class)
                .setParameter("id", id)
                .getSingleResult();

        return bookMapper.toDomain(bookEntity);
    }

}
