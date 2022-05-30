package app.spring.boot.controller;

import app.spring.boot.dto.EmployeeDto;
import app.spring.boot.model.Employee;
import app.spring.boot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<EmployeeDto> getEmployee() {
        log.info("Получаем данные для сервиса клиента");
        return employeeService.findAll();
    }

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody EmployeeDto employee) {
        employeeService.saveOrUpdate(employee);
        log.info("Успешное сохранение сотрудника");
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeeDto employee) {
        employeeService.saveOrUpdate(employee);
       //log.info("Успешное обновление сотрудника с id - {}", employee.getId());
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void delete(@PathVariable(name = "id") Long id) {

        if (id == -1L) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Неверно заданный id для удаления");
        }

        employeeService.delete(id);
    }
}
