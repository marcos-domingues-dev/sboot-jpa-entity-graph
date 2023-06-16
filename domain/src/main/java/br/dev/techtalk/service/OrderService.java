package br.dev.techtalk.service;

import br.dev.techtalk.domain.Order;
import br.dev.techtalk.repository.OrderRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrderService {

    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    };

    public Order findById(Long id) {
        return repository.findById(id);
    }

}
