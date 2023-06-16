package br.dev.techtalk.mapper.representation;

import br.dev.techtalk.domain.Customer;
import br.dev.techtalk.presentation.representation.CustomerRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerRepresentationMapper {
    CustomerRepresentation toRepresentation(Customer customer);

}
