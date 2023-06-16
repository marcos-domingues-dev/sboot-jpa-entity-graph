package br.dev.techtalk.infra.repository;

import br.dev.techtalk.domain.Order;
import br.dev.techtalk.infra.repository.entity.OrderEntity;
import br.dev.techtalk.infra.repository.jpa.JpaOrderRepository;
import br.dev.techtalk.mapper.OrderMapper;
import br.dev.techtalk.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private JpaOrderRepository jpaOrderRepository;

    private OrderMapper orderMapper;

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orderEntityList = jpaOrderRepository.findAll();

        return orderEntityList.stream()
                .map(e -> orderMapper.toDomain(e))
                .collect(Collectors.toList());
    }

    @Override
    public Order findById(Long id) {
        Optional<OrderEntity> order = jpaOrderRepository.findById(id);
        return orderMapper.toDomain(order.get());
    }

}
