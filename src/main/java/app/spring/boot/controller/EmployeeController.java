package app.spring.boot.controller;

import app.spring.boot.dto.EmployeeDto;
import app.spring.boot.model.Employee;
import app.spring.boot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/getEmployees")
    public List<EmployeeDto> getEmployee() {
        return employeeService.findAll();
    }

    @PostMapping("/saveEmployee")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        log.info("Успешное сохранение");
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.saveOrUpdate(employee);
        log.info("Успешное обновление");
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        try {
            employeeService.delete(id);
            log.info("Успешное удаление по id. Указанный id - {}", id);
        } catch (Exception e) {
            log.error("Ошибка удаления по id. Указанный id - {}", id);
        }
    }
}
