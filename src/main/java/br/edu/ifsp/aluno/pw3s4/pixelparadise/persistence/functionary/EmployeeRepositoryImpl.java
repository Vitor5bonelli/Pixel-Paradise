package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.functionary;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.RequestUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.UserAccountRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModelConverter;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount.UserAccountModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount.UserAccountModelConverter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final EmployeeDAO employeeDAO;

    private final UserAccountRepository userAccountRepository;

    public EmployeeRepositoryImpl(EmployeeDAO employeeDAO, UserAccountRepository userAccountRepository){this.employeeDAO = employeeDAO;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public void save(EmployeeDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (existsByKey(entityDTO.id()))
            throw new EntityAlreadyExistsException("There already is such employee!");

        employeeDAO.save(EmployeeModelConverter.fromDTO(entityDTO));
    }

    @Override
    public void update(EmployeeDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (!existsByKey(entityDTO.id()))
            throw new EntityAlreadyExistsException("There is not such employee!");


        employeeDAO.save(EmployeeModelConverter.fromDTO(entityDTO));
    }

    private UserAccountModel findUserAccountModel(UUID accountId) {
        RequestUserAccountDTO userAccountDTO = userAccountRepository.findOneByKey(accountId)
                .orElseThrow(() -> new EntityNotFoundException("There is not such account!"));

        return UserAccountModelConverter.fromDTO(userAccountDTO);
    }

    @Override
    public Optional<EmployeeDTO> findOneByKey(UUID key) {return null;}

    @Override
    public Optional<EmployeeDTO> findOneByCPF(String cpf) {
        return Optional.empty();
    }

    @Override
    public boolean existsByCPF(String cpf) {
        return false;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return null;
    }

    @Override
    public void deleteByKey(UUID key) {

    }

    @Override
    public boolean existsByKey(UUID key) {
        return false;
    }
}
