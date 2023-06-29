package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.PasswordEncoder;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserAccount;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee.Employee;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.*;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public final class CreateEmployeeUseCase {
    private final EmployeeRepository employeeRepository;
    private final CreateUserAccountUseCase createUserAccountUseCase;
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateEmployeeUseCase(EmployeeRepository employeeRepository,
                                 CreateUserAccountUseCase createUserAccountUseCase,
                                 UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository = employeeRepository;
        this.createUserAccountUseCase = createUserAccountUseCase;
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID createEmployee(CreateEmployeeDTO createEmployeeDTO, CreateUserAccountDTO createUserAccountDTO) {
        validateDTO(createEmployeeDTO);

        UUID accountId = createUserAccountUseCase.createEmployeeAccount(createUserAccountDTO);
        RequestUserAccountDTO userAccountDTO = userAccountRepository.findOneByKey(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Something happened while trying to create " +
                        "the account!"));
        UserAccount userAccount = UserAccountDTOConverter.fromRequestDTO(userAccountDTO, passwordEncoder);

        return saveEmployee(createEmployeeDTO, userAccount);
    }

    public UUID createAdmin(CreateEmployeeDTO createEmployeeDTO, CreateUserAccountDTO createUserAccountDTO) {
        validateDTO(createEmployeeDTO);

        UUID accountId = createUserAccountUseCase.createAdminAccount(createUserAccountDTO);
        RequestUserAccountDTO userAccountDTO = userAccountRepository.findOneByKey(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Something happened while trying to create " +
                        "the account!"));
        UserAccount userAccount = UserAccountDTOConverter.fromRequestDTO(userAccountDTO, passwordEncoder);

        return saveEmployee(createEmployeeDTO, userAccount);
    }

    private void validateDTO(CreateEmployeeDTO createEmployeeDTO) {
        Objects.requireNonNull(createEmployeeDTO);

        CreateEmployeeValidator validator = new CreateEmployeeValidator();
        Notification notification = validator.validate(createEmployeeDTO);

        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());

        if (employeeRepository.existsByCPF(createEmployeeDTO.cpf()))
            throw new EntityAlreadyExistsException("There already is an employee with such CPF!");
    }

    private UUID saveEmployee(CreateEmployeeDTO createEmployeeDTO, UserAccount userAccount) {
        Employee employee = EmployeeDTOConverter.fromCreateEmployeeDTO(createEmployeeDTO);
        employee.setAccount(userAccount);
        UUID employeeId = UUID.randomUUID();

        employeeRepository.save(EmployeeDTOConverter.toDTO(employee));

        return employeeId;
    }
}
