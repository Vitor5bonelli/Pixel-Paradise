package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public final class FindUserAccountUseCase {
    private final UserAccountRepository userAccountRepository;

    public FindUserAccountUseCase(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public Optional<ResponseUserAccountDTO> findOneById(UUID id) {
        Objects.requireNonNull(id);

        return userAccountRepository.findOneByKey(id)
                .map(UserAccountDTOConverter::requestDTOToResponseDTO);
    }

    public Optional<ResponseUserAccountDTO> findOneByUsername(String username) {
        Objects.requireNonNull(username);

        return userAccountRepository.findOneByUsername(username)
                .map(UserAccountDTOConverter::requestDTOToResponseDTO);
    }

    public List<ResponseUserAccountDTO> findAll() {
        return userAccountRepository.findAll()
                .stream()
                .map(UserAccountDTOConverter::requestDTOToResponseDTO)
                .toList();
    }
}
