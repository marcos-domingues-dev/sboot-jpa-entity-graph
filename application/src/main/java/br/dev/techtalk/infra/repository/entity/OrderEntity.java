package br.dev.techtalk.infra.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "bookstore_order")

@NamedEntityGraph(name = "orderAllMembers", attributeNodes = {
        @NamedAttributeNode("employee"),
        @NamedAttributeNode("customer"),
        @NamedAttributeNode(value = "items", subgraph = "items-subgraph")},
        subgraphs = {
                @NamedSubgraph(name = "items-subgraph", attributeNodes = {
                        @NamedAttributeNode(value = "book", subgraph = "book-subgraph")
                }),
                @NamedSubgraph(name = "book-subgraph", attributeNodes = {
                        @NamedAttributeNode("publisher"),
                        @NamedAttributeNode("authors")
                })
        }
)

@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    private List<OrderItemEntity> items = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
}
