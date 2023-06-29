package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.PasswordEncoder;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserAccount;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserPermission;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserAccountDTOConverter {
    public static UserAccount fromCreateUseAccountDTO(CreateUserAccountDTO createUserAccountDTO,
                                                     PasswordEncoder encoder) {
        Objects.requireNonNull(createUserAccountDTO);

        return new UserAccount(createUserAccountDTO.username(), createUserAccountDTO.email(),
                                encoder.encodePassword(createUserAccountDTO.password()));
    }

    public static UserAccount fromRequestDTO(RequestUserAccountDTO requestUserAccountDTO, PasswordEncoder encoder) {
        UserAccount userAccount = new UserAccount(requestUserAccountDTO.id(), requestUserAccountDTO.username(),
                        requestUserAccountDTO.email(), encoder.encodePassword(requestUserAccountDTO.password()));

        Set<UserPermission> permissions = Arrays.stream(requestUserAccountDTO.permissions())
                                            .map(UserPermission::fromString)
                                            .collect(Collectors.toSet());
        permissions.forEach(userAccount::grantPermission);

        return userAccount;
    }

    public static RequestUserAccountDTO entityToRequestDTO(UserAccount userAccount) {
        String[] permissions = (String[])userAccount.getPermissionsSet()
                                            .stream()
                                            .map(UserPermission::toString)
                                            .toArray();

        return new RequestUserAccountDTO(userAccount.getId(), userAccount.getUsername(), userAccount.getEmail(),
                        userAccount.getPasswordAsString(), permissions);
    }

    public static ResponseUserAccountDTO requestDTOToResponseDTO(RequestUserAccountDTO requestUserAccountDTO) {
        return new ResponseUserAccountDTO(requestUserAccountDTO.id(), requestUserAccountDTO.username(),
                        requestUserAccountDTO.email(), requestUserAccountDTO.permissions());
    }
}
