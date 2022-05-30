package app.spring.boot.service;

import app.spring.boot.dto.EmployeeDto;
import app.spring.boot.model.Employee;
import app.spring.boot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> EmployeeDto.builder()
                        .name(employee.getName())
                        .surname(employee.getSurname())
                        .salary(employee.getSalary())
                        .build())
                .collect(Collectors.toList());
    }

    public void saveOrUpdate(EmployeeDto employee) {

        Employee employeeEntity = new Employee();
        employeeEntity.setName(employee.getName());
        employeeEntity.setSalary(employee.getSalary());
        employeeEntity.setSurname(employee.getSurname());

        employeeRepository.save(employeeEntity);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}
