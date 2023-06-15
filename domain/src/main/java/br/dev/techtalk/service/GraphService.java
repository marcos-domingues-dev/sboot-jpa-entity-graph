package br.dev.techtalk.service;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.repository.BookGraphRepository;

import java.util.List;

public class GraphService {

    private final BookGraphRepository bookGraphRepository;

    public GraphService(BookGraphRepository bookGraphRepository) {
        this.bookGraphRepository = bookGraphRepository;
    }

    public List<Book> findAll() {
        return bookGraphRepository.findAll();
    }

    public List<Book> findAllUsingSpringDataAndGraph() {
        return bookGraphRepository.findAllUsingSpringDataAndGraph();
    }

    public Book graphNamedById(Long id, String graphName) {
        return bookGraphRepository.findBookWithNamedEntityGraphById(graphName, id);
    }

    public Book graphById(Long id) {
        return bookGraphRepository.findBookGraphAllMembersDynamicallyById(id);
    }

    public Book graphCustpmById(Long id, List<String> bookMembers) {
        return bookGraphRepository.findBookGraphCustomMembersDynamicallyById(id, bookMembers);
    }

}
