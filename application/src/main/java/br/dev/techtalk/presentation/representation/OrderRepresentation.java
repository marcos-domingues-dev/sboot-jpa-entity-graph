package br.dev.techtalk.presentation.representation;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class OrderRepresentation {

    private Long id;

    private List<OrderItemRepresentation> items = new ArrayList<>();

    private EmployeeRepresentation employee;

    private CustomerRepresentation customer;
}
