package app.spring.boot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

    private String name;
    private String surname;
    private int salary;
}
