package br.dev.techtalk.mapper.representation;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.presentation.representation.BookRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookRepresentationMapper {

    BookRepresentation toRepresentation(Book book);

}
