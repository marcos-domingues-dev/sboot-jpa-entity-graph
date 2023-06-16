package br.dev.techtalk.mapper.representation;

import br.dev.techtalk.domain.Employee;
import br.dev.techtalk.presentation.representation.EmployeeRepresentation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeRepresentationMapper {

    EmployeeRepresentation toRepresentation(Employee employee);

}
