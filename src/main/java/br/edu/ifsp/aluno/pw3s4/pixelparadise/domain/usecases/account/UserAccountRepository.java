package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepository extends Repository<UUID, RequestUserAccountDTO> {
    Optional<RequestUserAccountDTO> findOneByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsCustomerAccountByUsername(String username);

    boolean existsEmployeeAccountByUsername(String username);
}
