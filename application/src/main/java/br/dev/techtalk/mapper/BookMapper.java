package br.dev.techtalk.mapper;

import br.dev.techtalk.domain.Author;
import br.dev.techtalk.domain.Book;
import br.dev.techtalk.infra.repository.entity.AuthorEntity;
import br.dev.techtalk.infra.repository.entity.BookEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book toDomain(BookEntity entity);

    Author map(AuthorEntity entity);
}
