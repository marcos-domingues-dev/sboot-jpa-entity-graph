package br.dev.techtalk.mapper.representation;

import br.dev.techtalk.domain.OrderItem;
import br.dev.techtalk.presentation.representation.OrderItemRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemRepresentationMapper {

    OrderItemRepresentation toRepresentation(OrderItem orderItem);

}
