package br.dev.techtalk.infra.repository;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.domain.constants.BookGraphConst;
import br.dev.techtalk.domain.enumeration.BookNodesEnum;
import br.dev.techtalk.infra.repository.entity.BookEntity;
import br.dev.techtalk.infra.repository.jpa.JpaBookGraphRepository;
import br.dev.techtalk.mapper.BookMapper;
import br.dev.techtalk.mapper.CustomBookMapper;
import br.dev.techtalk.repository.BookGraphRepository;
import jakarta.persistence.AttributeNode;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookGraphRepositoryImpl implements BookGraphRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    JpaBookGraphRepository jpaBookGraphRepository;

    @Autowired
    CustomBookMapper customBookMapper;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> findAll_WithSpringDataJPA() {
        List<BookEntity> allBooks = jpaBookGraphRepository.findAll();

        return allBooks.stream()
                .map(bookEntity -> bookMapper.toDomain(bookEntity))
                .collect(Collectors.toList());
    }

    @Override
    public Book findBookById_WithSpringDataJPA(Long id) {
        Optional<BookEntity> bookEntityOptional = jpaBookGraphRepository.findById(id);
        return bookMapper.toDomain(bookEntityOptional.get());
    }

    @Override
    public Book findBookById_UsingDeclarativeEntityGraph(String graphName, Long id) {
        // Declarative JPA Entity Graph
        EntityGraph entityGraph = entityManager.getEntityGraph(graphName);

        // Query
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.fetchgraph", entityGraph);
        BookEntity bookEntity = entityManager.find(BookEntity.class, id, properties);

        // Extract Nodes From EntityGraph
        List<String> bookNodes = (List<String>) entityGraph.getAttributeNodes().stream()
                .map(a -> ((AttributeNode) a).getAttributeName())
                .collect(Collectors.toList());

        // Result
        return customBookMapper.bookMapperWithCustomNodes(bookEntity, bookNodes);
    }

    @Override
    public Book findBookById_UsingProgramaticEntityGraph(Long id) {
        // Programmatic JPA Entity Graph
        EntityGraph<BookEntity> entityGraph = buildEntityGraph(BookGraphConst.PUBLIC_NODES);

        // Query
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.fetchgraph", entityGraph);
        BookEntity bookEntity = entityManager.find(BookEntity.class, id, properties);

        // Result
        return customBookMapper.bookMapperWithCustomNodes(bookEntity, BookGraphConst.PUBLIC_NODES);
    }

    @Override
    public Book findBookById_UsingProgramaticEntityGraph_CustomNodes(Long id, List<String> bookNodes) {
        // Programmatic JPA Entity Graph
        EntityGraph<BookEntity> entityGraph = buildEntityGraph(bookNodes);

        // Query
        Map<String, Object> properties = new HashMap<>();
        properties.put("jakarta.persistence.fetchgraph", entityGraph);
        BookEntity bookEntity = entityManager.find(BookEntity.class, id, properties);

        // Result
        return customBookMapper.bookMapperWithCustomNodes(bookEntity, bookNodes);
    }

    private EntityGraph<BookEntity> buildEntityGraphV1(List<String> bookNodes) {
        EntityGraph<BookEntity> entityGraph = entityManager.createEntityGraph(BookEntity.class);
        entityGraph.addAttributeNodes(BookNodesEnum.PUBLISHER.getValue());
        entityGraph.addAttributeNodes(BookNodesEnum.AUTHORS.getValue());
        return entityGraph;
    }

    private EntityGraph<BookEntity> buildEntityGraphV2(List<String> bookNodes) {
        EntityGraph<BookEntity> entityGraph = entityManager.createEntityGraph(BookEntity.class);

        if (bookNodes == null || bookNodes.contains(BookNodesEnum.PUBLISHER.getValue())) {
            entityGraph.addAttributeNodes(BookNodesEnum.PUBLISHER.getValue());
        }

        if (bookNodes == null || bookNodes.contains(BookNodesEnum.AUTHORS.getValue())) {
            entityGraph.addAttributeNodes(BookNodesEnum.AUTHORS.getValue());
        }

        return entityGraph;
    }

    private EntityGraph<BookEntity> buildEntityGraph(List<String> bookNodes) {
        EntityGraph<BookEntity> result = entityManager.createEntityGraph(BookEntity.class);

        // Accept: Public vs Request Nodes
        List<String> publicNodeList = null;
        if (bookNodes == null || bookNodes.size() == 0) {
            publicNodeList = BookGraphConst.PUBLIC_NODES;
        } else {
            // Only public node
            publicNodeList = bookNodes.stream()
                    .filter(m -> BookGraphConst.PUBLIC_NODES.contains(m))
                    .collect(Collectors.toList());
        }

        // Reflection - Class member list
        Field[] fields = BookEntity.class.getDeclaredFields();
        for (Field field : fields) {
            if (publicNodeList.contains(field.getName())) {
                result.addAttributeNodes(field.getName());
            }
        }

        return result;
    }

}
