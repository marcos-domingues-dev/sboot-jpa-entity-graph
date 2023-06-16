package br.dev.techtalk.repository;

import br.dev.techtalk.domain.Order;

import java.util.List;

public interface OrderRepository {

    List<Order> findAll();

    Order findById(Long id);
}
