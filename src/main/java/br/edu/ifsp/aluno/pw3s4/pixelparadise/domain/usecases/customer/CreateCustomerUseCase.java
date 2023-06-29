package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.PasswordEncoder;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserAccount;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.*;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;

import java.util.Objects;
import java.util.UUID;

public class CreateCustomerUseCase {
    private final CustomerRepository customerRepository;
    private final UserAccountRepository userAccountRepository;
    private final CreateUserAccountUseCase createUserAccountUseCase;
    private final PasswordEncoder passwordEncoder;

    public CreateCustomerUseCase(CustomerRepository customerRepository,UserAccountRepository userAccountRepository,
                                 CreateUserAccountUseCase createUserAccountUseCase, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.userAccountRepository = userAccountRepository;
        this.createUserAccountUseCase = createUserAccountUseCase;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID createCustomer(CreateCustomerDTO createCustomerDTO, CreateUserAccountDTO createUserAccountDTO) {
        Objects.requireNonNull(createCustomerDTO);

        CreateCustomerValidator validator = new CreateCustomerValidator();
        Notification notification = validator.validate(createCustomerDTO);

        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());
        if (customerRepository.existsByNickname(createUserAccountDTO.username()))
            throw new EntityAlreadyExistsException("There already is a customer with such nickname!");

        UserAccount account = createAccount(createUserAccountDTO);
        UUID customerId = UUID.randomUUID();
        Customer customer = CustomerDTOConverter.fromCreateCustomerDTO(createCustomerDTO);
        customer.setId(customerId);
        customer.setAccount(account);

        customerRepository.save(CustomerDTOConverter.toDTO(customer));
        
        return customerId;
    }

    private UserAccount createAccount(CreateUserAccountDTO createUserAccountDTO) {
        Objects.requireNonNull(createUserAccountDTO);

        UUID accountId = createUserAccountUseCase.createCustomerAccount(createUserAccountDTO);
        RequestUserAccountDTO userAccountDTO = userAccountRepository.findOneByKey(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Something happened while attempting to create " +
                        "an account!"));

        return UserAccountDTOConverter.fromRequestDTO(userAccountDTO, passwordEncoder);
    }
}
