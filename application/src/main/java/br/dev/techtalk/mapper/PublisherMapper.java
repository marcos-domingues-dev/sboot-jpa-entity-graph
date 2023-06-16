package br.dev.techtalk.mapper;

import br.dev.techtalk.domain.Publisher;
import br.dev.techtalk.infra.repository.entity.PublisherEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    Publisher toDomain(PublisherEntity entity);

    PublisherEntity toEntity(Publisher publisher);
}
