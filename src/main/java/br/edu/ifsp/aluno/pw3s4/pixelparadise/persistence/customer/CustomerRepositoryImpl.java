package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private final CustomerDAO customerDAO;

    public CustomerRepositoryImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void save(CustomerDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (existsByKey(entityDTO.id()))
            throw new EntityAlreadyExistsException("There already is such customer!");

        customerDAO.save(CustomerModelConverter.fromDTO(entityDTO));
    }

    @Override
    public Optional<CustomerDTO> findOneByKey(UUID key) {
        Objects.requireNonNull(key);

        return customerDAO.findById(key)
                .map(CustomerModelConverter::toDTO);
    }

    @Override
    public Optional<CustomerDTO> findOneByNickname(String nickname) {
        Objects.requireNonNull(nickname);

        CustomerModel customerModel = new CustomerModel();
        customerModel.setNickname(nickname);

        return customerDAO.findOne(Example.of(customerModel))
                .map(CustomerModelConverter::toDTO);
    }

    @Override
    public Optional<CustomerDTO> findOneByAccountId(UUID accountId) {
        Objects.requireNonNull(accountId);

        return Optional.empty();
    }

    @Override
    public List<CustomerDTO> findAll() {
        return customerDAO.findAll()
                .stream()
                .map(CustomerModelConverter::toDTO)
                .toList();
    }

    @Override
    public void update(CustomerDTO entityDTO) {
        Objects.requireNonNull(entityDTO);

        if (!existsByKey(entityDTO.id()))
            throw new EntityNotFoundException("There is not such customer!");

        customerDAO.save(CustomerModelConverter.fromDTO(entityDTO));
    }

    @Override
    public void deleteByKey(UUID key) {
        Objects.requireNonNull(key);

        customerDAO.deleteById(key);
    }

    @Override
    public boolean existsByKey(UUID key) {
        return customerDAO.existsById(key);
    }

    @Override
    public boolean existsByNickname(String nickname) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setNickname(nickname);

        return customerDAO.exists(Example.of(customerModel));
    }
}
