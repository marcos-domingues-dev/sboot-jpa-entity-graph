package br.dev.techtalk.presentation;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.domain.enumeration.BookNodesEnum;
import br.dev.techtalk.mapper.representation.BookRepresentationMapper;
import br.dev.techtalk.presentation.representation.BookRepresentation;
import br.dev.techtalk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepresentationMapper bookRepresentationMapper;

    @GetMapping
    public ResponseEntity<List<BookRepresentation>> listAll() {
        List<Book> books = bookService.findAll();
        var result = books.stream().map(b -> bookRepresentationMapper.toRepresentation(b))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<BookRepresentation> findById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/find/custom-mapper/{id}")
    public ResponseEntity<BookRepresentation> findCustomById(@PathVariable Long id) {
        List<String> bookNodes = Arrays.asList(BookNodesEnum.BOOK.getValue());
        Book book = bookService.findById(id, bookNodes);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/find/custom-fetch/{id}")
    public ResponseEntity<BookRepresentation> findCustomFetchById(@PathVariable Long id) {
        Book book = bookService.findCustomFetchById(id);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

}