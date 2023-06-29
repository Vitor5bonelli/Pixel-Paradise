package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee.Employee;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public final class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public CreateEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    public UUID createEmployee(CreateEmployeeDTO createEmployeeDTO) {
        Objects.requireNonNull(createEmployeeDTO);

        CreateEmployeeValidator validator = new CreateEmployeeValidator();
        Notification notification = validator.validate(createEmployeeDTO);
        
        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());

        if (employeeRepository.existsByCPF(createEmployeeDTO.cpf()))
            throw new EntityAlreadyExistsException("There already is an employee with such CPF!");

        Employee employee = EmployeeDTOConverter.fromCreateEmployeeDTO(createEmployeeDTO);
        UUID employeeId = UUID.randomUUID();

        employeeRepository.save(EmployeeDTOConverter.toDTO(employee));
        
        return employeeId;
    }
}
