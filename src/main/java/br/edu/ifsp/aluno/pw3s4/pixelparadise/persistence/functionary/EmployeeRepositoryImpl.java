package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.functionary;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModelConverter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeDAO employeeDAO;

    public EmployeeRepositoryImpl(EmployeeDAO employeeDAO){this.employeeDAO = employeeDAO;}

    @Override
    public void save(EmployeeDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (existsByKey(entityDTO.id()))
            throw new EntityAlreadyExistsException("There already is such employee!");

        employeeDAO.save(EmployeeModelConverter.fromDTO(entityDTO));
    }

    @Override
    public Optional<EmployeeDTO> findOneByCPF(String cpf) {
        return Optional.empty();
    }

    @Override
    public boolean existsByCPF(String cpf) {
        return false;
    }

    @Override
    public Optional<EmployeeDTO> findOneByKey(UUID key) {
        return Optional.empty();
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return null;
    }

    @Override
    public void update(EmployeeDTO entityDTO) {

    }

    @Override
    public void deleteByKey(UUID key) {

    }

    @Override
    public boolean existsByKey(UUID key) {
        return false;
    }
}
