package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Book;

import java.util.List;

public interface BookGraphRepository {

    List<Book> findAll_WithSpringDataJPA();

    Book findBookById_WithSpringDataJPA(Long id);

    Book findBookById_UsingDeclarativeEntityGraph(String graphName, Long id);

    Book findBookById_UsingProgramaticEntityGraph(Long id);

    Book findBookById_UsingProgramaticEntityGraph_CustomNodes(Long id, List<String> bookNodes);


}
