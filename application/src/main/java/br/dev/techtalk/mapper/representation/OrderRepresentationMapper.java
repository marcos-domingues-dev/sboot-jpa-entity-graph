package br.dev.techtalk.mapper.representation;

import br.dev.techtalk.domain.Order;
import br.dev.techtalk.presentation.representation.OrderRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderRepresentationMapper {

    OrderRepresentation toRepresentation(Order order);

}
