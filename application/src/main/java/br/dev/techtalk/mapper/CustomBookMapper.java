package br.dev.techtalk.mapper;

import br.dev.techtalk.domain.Author;
import br.dev.techtalk.domain.Book;
import br.dev.techtalk.domain.Publisher;
import br.dev.techtalk.domain.enumeration.BookNodesEnum;
import br.dev.techtalk.infra.repository.entity.BookEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomBookMapper {

    public Book bookMapperWithCustomNodes(BookEntity bookEntity, List<String> bookNodes) {
        Book book = Book.builder()
                .id(bookEntity.getId())
                .code(bookEntity.getCode())
                .title(bookEntity.getTitle())
                .build();

        if (bookNodes == null || bookNodes.contains(BookNodesEnum.PUBLISHER.getValue())) {
            if (bookEntity.getPublisher() != null) {
                Publisher publisher = Publisher.builder()
                        .id(bookEntity.getPublisher().getId())
                        .code(bookEntity.getPublisher().getCode())
                        .name(bookEntity.getPublisher().getName())
                        .build();
                book.setPublisher(publisher);
            }
        }

        if (bookNodes == null || bookNodes.contains(BookNodesEnum.AUTHORS.getValue())) {
            if (bookEntity.getAuthors() != null && bookEntity.getAuthors().size() > 0) {
                List<Author> authors = bookEntity.getAuthors().stream().map(a ->
                        Author.builder()
                                .id(a.getId())
                                .code(a.getCode())
                                .name(a.getName())
                                .email(a.getEmail())
                                .build()
                ).collect(Collectors.toList());
                book.setAuthors(authors);
            }
        }

        return book;
    }

}
