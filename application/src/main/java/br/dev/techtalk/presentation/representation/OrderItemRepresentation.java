package br.dev.techtalk.presentation.representation;

import br.dev.techtalk.domain.Book;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class OrderItemRepresentation {

    private Long id;

    private OrderRepresentation order;

    private Book book;

}
