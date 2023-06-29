package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends Repository<UUID, CustomerDTO> {
    Optional<CustomerDTO> findOneByNickname(String nickname);

    boolean existsByNickname(String nickname);
}
