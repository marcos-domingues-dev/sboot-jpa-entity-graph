package br.dev.techtalk.infra.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "book.findAll", query = "SELECT b FROM book b")
})

@NamedEntityGraphs({
        @NamedEntityGraph(name = "bookAllNodes", attributeNodes = {
                @NamedAttributeNode("publisher"),
                @NamedAttributeNode("authors"),

        }),
        @NamedEntityGraph(name = "bookAndPublisher", attributeNodes = {
                @NamedAttributeNode("publisher"),

        }),
        @NamedEntityGraph(name = "bookAndAuthors", attributeNodes = {
                @NamedAttributeNode("authors"),
        })
})

@Getter
@Setter
@Entity(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "publisher_id")
    private PublisherEntity publisher;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<AuthorEntity> authors = new ArrayList<>();

}
