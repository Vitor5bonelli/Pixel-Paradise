package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends Repository<UUID, EmployeeDTO> {
    Optional<EmployeeDTO> findOneByCPF(String cpf);

    boolean existsByCPF(String cpf);
}
