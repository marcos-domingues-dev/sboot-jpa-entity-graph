package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerRepresentation {

    private Long id;

    private String code;

    private String name;

}
