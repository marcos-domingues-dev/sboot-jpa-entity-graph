package br.dev.techtalk.mapper;

import br.dev.techtalk.domain.Author;
import br.dev.techtalk.infra.repository.entity.AuthorEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toDomain(AuthorEntity entity);

    AuthorEntity toEntity(Author author);

}
