package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;

import java.util.UUID;

public interface UserAccountRepository extends Repository<UUID, RequestUserAccountDTO> {
    boolean existsByUsername(String username);

    boolean existsCustomerAccountByUsername(String username);

    boolean existsEmployeeAccountByUsername(String username);
}
