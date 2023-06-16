package br.dev.techtalk.presentation;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.mapper.representation.BookRepresentationMapper;
import br.dev.techtalk.presentation.representation.BookRepresentation;
import br.dev.techtalk.service.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("book")
public class GraphController {

    @Autowired
    private GraphService graphService;

    @Autowired
    private BookRepresentationMapper bookRepresentationMapper;


    @GetMapping(value = "/graph/all-nodes")
    public ResponseEntity<List<BookRepresentation>> findAll() {
        List<Book> books = graphService.findAll_WithSpringDataJPA();
        var result = books.stream()
                .map(b -> bookRepresentationMapper.toRepresentation(b))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}/graph/all-nodes")
    public ResponseEntity<BookRepresentation> graphFullNodesById(@PathVariable Long id) {
        Book book = graphService.findBookById_WithSpringDataJPA(id);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "{id}/graph/programatic")
    public ResponseEntity<BookRepresentation> graphById(@PathVariable Long id) {
        Book book = graphService.findBookById_UsingProgramaticEntityGraph(id);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}/graph/declarative")
    public ResponseEntity<BookRepresentation> graphNamedById(@PathVariable Long id, @RequestParam(name = "graphName") String graphName) {
        Book book = graphService.findBookById_UsingDeclarativeEntityGraph(graphName, id);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "{id}/graph/declarative/custom-nodes")
    public ResponseEntity<BookRepresentation> graphCustpmById(@PathVariable Long id, @RequestParam(name = "bookNodes") List<String> bookNodes) {
        Book book = graphService.findBookById_UsingProgramaticEntityGraph_CustomNodes(id, bookNodes);
        BookRepresentation result = bookRepresentationMapper.toRepresentation(book);
        return ResponseEntity.ok(result);
    }

}