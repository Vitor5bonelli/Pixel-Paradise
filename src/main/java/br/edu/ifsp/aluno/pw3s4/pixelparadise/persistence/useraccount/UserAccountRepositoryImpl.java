package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.RequestUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.UserAccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserAccountRepositoryImpl implements UserAccountRepository {

    private final UserAccountDAO userAccountDAO;

    public UserAccountRepositoryImpl(UserAccountDAO userAccountDAO) {
        this.userAccountDAO = userAccountDAO;
    }

    @Override
    public Optional<RequestUserAccountDTO> findOneByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean existsByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsCustomerAccountByUsername(String username) {
        return false;
    }

    @Override
    public boolean existsEmployeeAccountByUsername(String username) {
        return false;
    }

    @Override
    public void save(RequestUserAccountDTO entityDTO) {

    }

    @Override
    public Optional<RequestUserAccountDTO> findOneByKey(UUID key) {
        return Optional.empty();
    }

    @Override
    public List<RequestUserAccountDTO> findAll() {
        return null;
    }

    @Override
    public void update(RequestUserAccountDTO entityDTO) {

    }

    @Override
    public void deleteByKey(UUID key) {

    }

    @Override
    public boolean existsByKey(UUID key) {
        return false;
    }
}
