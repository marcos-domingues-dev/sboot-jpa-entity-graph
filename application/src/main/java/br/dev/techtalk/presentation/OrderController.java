package br.dev.techtalk.presentation;

import br.dev.techtalk.domain.Book;
import br.dev.techtalk.domain.Order;
import br.dev.techtalk.mapper.representation.OrderRepresentationMapper;
import br.dev.techtalk.presentation.representation.BookRepresentation;
import br.dev.techtalk.presentation.representation.OrderRepresentation;
import br.dev.techtalk.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private OrderRepresentationMapper mapper;

    @GetMapping
    public ResponseEntity<List<OrderRepresentation>> listAll() {
        List<Order> orderList = service.findAll();
        var result = orderList.stream().map(b -> mapper.toRepresentation(b))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<OrderRepresentation> findById(@PathVariable Long id) {
        Order order = service.findById(id);
        OrderRepresentation result = mapper.toRepresentation(order);
        return ResponseEntity.ok(result);
    }

}
