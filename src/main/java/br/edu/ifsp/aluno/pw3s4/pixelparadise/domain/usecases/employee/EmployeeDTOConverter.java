package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee.Employee;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.util.CPF;

public final class EmployeeDTOConverter {
    public static Employee fromCreateEmployeeDTO(CreateEmployeeDTO createEmployeeDTO) {
        CPF cpf = CPF.of(createEmployeeDTO.cpf());

        return new Employee(createEmployeeDTO.preferredName(), cpf, createEmployeeDTO.phoneNumber(),
                createEmployeeDTO.wageInCents());
    }

    public static Employee fromDTO(EmployeeDTO employeeDTO) {
        CPF cpf = CPF.of(employeeDTO.cpf());

        return new Employee(employeeDTO.id(), employeeDTO.preferredName(), cpf, employeeDTO.phoneNumber(),
                employeeDTO.wageInCents());
    }

    public static EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(employee.getId(), employee.getPreferredName(), employee.getCpf().toString(),
                employee.getPhoneNumber(), employee.getWageInCents());
    }
}
