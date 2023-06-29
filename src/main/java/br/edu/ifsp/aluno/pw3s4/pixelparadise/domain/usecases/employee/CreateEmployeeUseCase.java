package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee.Employee;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.CreateUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.CreateUserAccountUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public final class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;
    private final CreateUserAccountUseCase createUserAccountUseCase;

    public CreateEmployeeUseCase(EmployeeRepository employeeRepository, CreateUserAccountUseCase createUserAccountUseCase) {
        this.employeeRepository = employeeRepository;
        this.createUserAccountUseCase = createUserAccountUseCase;
    }

    public UUID createEmployee(CreateEmployeeDTO createEmployeeDTO, CreateUserAccountDTO createUserAccountDTO) {
        Objects.requireNonNull(createEmployeeDTO);

        CreateEmployeeValidator validator = new CreateEmployeeValidator();
        Notification notification = validator.validate(createEmployeeDTO);
        
        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());

        if (employeeRepository.existsByCPF(createEmployeeDTO.cpf()))
            throw new EntityAlreadyExistsException("There already is an employee with such CPF!");

        UUID accountId = createUserAccountUseCase.createEmployeeAccount(createUserAccountDTO);

        // todo: pegar a conta gerada usando um FindUserAccountUseCase.findOneById()
        Employee employee = EmployeeDTOConverter.fromCreateEmployeeDTO(createEmployeeDTO);
        UUID employeeId = UUID.randomUUID();

        employeeRepository.save(EmployeeDTOConverter.toDTO(employee));
        
        return employeeId;
    }
}
