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
public class Order {

    private Long id;

    private List<OrderItem> items = new ArrayList<>();

    private Employee employee;

    private Customer customer;
}
