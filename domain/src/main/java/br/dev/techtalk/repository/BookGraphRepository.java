package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Book;

import java.util.List;

public interface BookGraphRepository {

    List<Book> findAll();

    List<Book> findAllUsingSpringDataAndGraph();

    Book findBookWithNamedEntityGraphById(String graphName, Long id);

    Book findBookGraphAllMembersDynamicallyById(Long id);

    Book findBookGraphCustomMembersDynamicallyById(Long id, List<String> bookMembers);


}
