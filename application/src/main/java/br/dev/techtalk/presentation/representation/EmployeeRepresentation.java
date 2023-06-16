package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeRepresentation {

    private Long id;

    private String code;

    private String name;

}
