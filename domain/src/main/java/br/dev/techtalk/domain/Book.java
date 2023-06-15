package br.dev.techtalk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private Long id;

    private String code;

    private String title;

    private Publisher publisher;

    private List<Author> authors = new ArrayList<>();

}
