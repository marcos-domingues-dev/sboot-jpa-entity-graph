package br.dev.techtalk.mapper;

import br.dev.techtalk.domain.Customer;
import br.dev.techtalk.domain.Employee;
import br.dev.techtalk.domain.Order;
import br.dev.techtalk.domain.OrderItem;
import br.dev.techtalk.infra.repository.entity.CustomerEntity;
import br.dev.techtalk.infra.repository.entity.EmployeeEntity;
import br.dev.techtalk.infra.repository.entity.OrderEntity;
import br.dev.techtalk.infra.repository.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toDomain(OrderEntity entity);


    @Mapping(target = "order", ignore = true)
    OrderItem itemMap(OrderItemEntity orderItem);

    Employee employeeMap(EmployeeEntity employee);

    Customer customerMap(CustomerEntity customer);


}
