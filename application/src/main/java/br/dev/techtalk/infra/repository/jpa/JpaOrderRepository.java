package br.dev.techtalk.infra.repository.jpa;

import br.dev.techtalk.infra.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaOrderRepository extends JpaRepository<OrderEntity, Long> {

    @Override
    @EntityGraph(value = "orderAllMembers", type = EntityGraph.EntityGraphType.FETCH)
    List<OrderEntity> findAll();

    @Override
    @EntityGraph(value = "orderAllMembers")
    Optional<OrderEntity> findById(Long aLong);
}
