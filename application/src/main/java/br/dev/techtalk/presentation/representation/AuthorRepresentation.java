package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthorRepresentation {

    private String code;

    private String name;

    private String email;

}
