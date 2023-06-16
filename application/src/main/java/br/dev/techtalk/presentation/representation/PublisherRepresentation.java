package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PublisherRepresentation {

    private String code;

    private String name;

}
