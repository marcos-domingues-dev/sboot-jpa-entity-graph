package br.dev.techtalk.service;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.repository.BookGraphRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class GraphService {

    private final BookGraphRepository bookGraphRepository;

    public List<Book> findAll_WithSpringDataJPA() {
        return bookGraphRepository.findAll_WithSpringDataJPA();
    }

    public Book findBookById_WithSpringDataJPA(Long id) {
        return bookGraphRepository.findBookById_WithSpringDataJPA(id);
    }

    public Book findBookById_UsingDeclarativeEntityGraph(String graphName, Long id) {
        return bookGraphRepository.findBookById_UsingDeclarativeEntityGraph(graphName, id);
    }

    public Book findBookById_UsingProgramaticEntityGraph(Long id) {
        return bookGraphRepository.findBookById_UsingProgramaticEntityGraph(id);
    }

    public Book findBookById_UsingProgramaticEntityGraph_CustomNodes(Long id, List<String> bookNodes) {
        return bookGraphRepository.findBookById_UsingProgramaticEntityGraph_CustomNodes(id, bookNodes);
    }

}
