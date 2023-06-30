package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.util.CPF;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public final class FindEmployeeUseCase {
    private final EmployeeRepository employeeRepository;

    public FindEmployeeUseCase(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Optional<EmployeeDTO> findOneById(UUID id) {
        Objects.requireNonNull(id);

        return employeeRepository.findOneByKey(id);
    }

    public Optional<EmployeeDTO> findOneByCPF(String cpf) {
        Objects.requireNonNull(cpf);

        CPF validatedCPF = CPF.of(cpf);

        return employeeRepository.findOneByCPF(validatedCPF.toString());
    }

    public Optional<EmployeeDTO> findOneByNickname(String nickname) {
        Objects.requireNonNull(nickname);

        return employeeRepository.findOneByNickname(nickname);
    }

    public List<EmployeeDTO> findAll() {
        return employeeRepository.findAll();
    }
}
