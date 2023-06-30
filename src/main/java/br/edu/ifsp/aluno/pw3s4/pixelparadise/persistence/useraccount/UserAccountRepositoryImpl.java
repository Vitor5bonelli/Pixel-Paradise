package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.RequestUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.UserAccountRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerDAO;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {
    private final UserAccountDAO userAccountDAO;
    private final CustomerDAO customerDAO;

    public UserAccountRepositoryImpl(UserAccountDAO userAccountDAO, CustomerDAO customerDAO) {
        this.userAccountDAO = userAccountDAO;
        this.customerDAO = customerDAO;
    }

    @Override
    public void save(RequestUserAccountDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (existsByKey(entityDTO.id()))
            throw new EntityAlreadyExistsException("There already is such user account");

        userAccountDAO.save(UserAccountModelConverter.fromDTO(entityDTO));
    }

    @Override
    public Optional<RequestUserAccountDTO> findOneByKey(UUID key) {
        Objects.requireNonNull(key);

        return userAccountDAO.findById(key)
                .map(UserAccountModelConverter::toDTO);
    }

    @Override
    public Optional<RequestUserAccountDTO> findOneByUsername(String username) {
        Objects.requireNonNull(username);

        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUsername(username);

        return userAccountDAO.findOne(Example.of(userAccountModel))
                .map(UserAccountModelConverter::toDTO);
    }

    @Override
    public List<RequestUserAccountDTO> findAll() {
        return userAccountDAO.findAll()
                .stream()
                .map(UserAccountModelConverter::toDTO)
                .toList();
    }

    @Override
    public void update(RequestUserAccountDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (!existsByKey(entityDTO.id()))
            throw new EntityNotFoundException("There is not such user account!");

        userAccountDAO.save(UserAccountModelConverter.fromDTO(entityDTO));
    }

    @Override
    public void deleteByKey(UUID key) {
        userAccountDAO.deleteById(key);
    }

    @Override
    public boolean existsByKey(UUID key) {
        return false;
    }

    @Override
    public boolean existsByUsername(String username) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUsername(username);

        return userAccountDAO.exists(Example.of(userAccountModel));
    }

    @Override
    public boolean existsCustomerAccountByUsername(String username) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUsername(username);

        Optional<UserAccountModel> maybeUserAccountModel = userAccountDAO.findOne(Example.of(userAccountModel));

        if (maybeUserAccountModel.isEmpty())
            return false;

        UUID accountId = maybeUserAccountModel.get().getId();

        return customerDAO.findAll()
                .stream()
                .anyMatch(customerModel -> customerModel.getUserAccountModel().getId().equals(accountId));
    }

    // todo: implementar busca da conta por employee
    @Override
    public boolean existsEmployeeAccountByUsername(String username) {
        UserAccountModel userAccountModel = new UserAccountModel();
        userAccountModel.setUsername(username);

        return userAccountDAO.exists(Example.of(userAccountModel));
    }
}
