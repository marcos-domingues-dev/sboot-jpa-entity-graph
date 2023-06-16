package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class BookRepresentation {

    private String code;

    private String title;

    private PublisherRepresentation publisher;

    private List<AuthorRepresentation> authors = new ArrayList<>();

}
