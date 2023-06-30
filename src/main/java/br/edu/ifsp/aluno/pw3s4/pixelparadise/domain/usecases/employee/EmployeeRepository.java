package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;

import java.util.Optional;
import java.util.UUID;

@org.springframework.stereotype.Repository
public interface EmployeeRepository extends Repository<UUID, EmployeeDTO> {
    Optional<EmployeeDTO> findOneByCPF(String cpf);

    public Optional<EmployeeDTO> findOneByNickname(String nickname);

    boolean existsByCPF(String cpf);
}
