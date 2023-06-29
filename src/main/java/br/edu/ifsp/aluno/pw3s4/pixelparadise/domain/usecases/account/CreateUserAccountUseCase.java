package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.PasswordEncoder;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserAccount;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public final class CreateUserAccountUseCase {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public CreateUserAccountUseCase(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID createCustomerAccount(CreateUserAccountDTO createUserAccountDTO) {
        validateDTO(createUserAccountDTO);

        UserAccount userAccount = convertDTOToEntity(createUserAccountDTO);

        UserPermissionsGranter userPermissionsGranter = new UserPermissionsGranter();
        userPermissionsGranter.getCustomerPermissionSet()
                .forEach(userAccount::grantPermission);

        userAccountRepository.save(UserAccountDTOConverter.entityToRequestDTO(userAccount));

        return userAccount.getId();
    }

    public UUID createEmployeeAccount(CreateUserAccountDTO createUserAccountDTO) {
        validateDTO(createUserAccountDTO);

        UserAccount userAccount = convertDTOToEntity(createUserAccountDTO);

        UserPermissionsGranter userPermissionsGranter = new UserPermissionsGranter();
        userPermissionsGranter.getEmployeePermissionSet()
                .forEach(userAccount::grantPermission);

        userAccountRepository.save(UserAccountDTOConverter.entityToRequestDTO(userAccount));

        return userAccount.getId();
    }

    public UUID createAdminAccount(CreateUserAccountDTO createUserAccountDTO) {
        validateDTO(createUserAccountDTO);

        UserAccount userAccount = convertDTOToEntity(createUserAccountDTO);

        UserPermissionsGranter userPermissionsGranter = new UserPermissionsGranter();
        userPermissionsGranter.getAdminPermissionSet()
                .forEach(userAccount::grantPermission);

        userAccountRepository.save(UserAccountDTOConverter.entityToRequestDTO(userAccount));

        return userAccount.getId();
    }

    private void validateDTO(CreateUserAccountDTO createUserAccountDTO) {
        Objects.requireNonNull(createUserAccountDTO);

        CreateUserAccountValidator validator = new CreateUserAccountValidator();
        Notification notification = validator.validate(createUserAccountDTO);

        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());
        if (userAccountRepository.existsCustomerAccountByUsername(createUserAccountDTO.username()))
            throw new EntityAlreadyExistsException("such username is not available");
        if (userAccountRepository.existsEmployeeAccountByUsername(createUserAccountDTO.username()))
            throw new EntityAlreadyExistsException("Such username is not available!");
    }

    private UserAccount convertDTOToEntity(CreateUserAccountDTO createUserAccountDTO) {
        UserAccount userAccount = UserAccountDTOConverter.fromCreateUseAccountDTO(createUserAccountDTO,
                passwordEncoder);
        UUID accountID = UUID.randomUUID();
        userAccount.setId(accountID);

        return userAccount;
    }
}
