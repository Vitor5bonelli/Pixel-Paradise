package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
@Service
public final class FindCustomerUseCase {
    private final CustomerRepository customerRepository;

    public FindCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<CustomerDTO> findOneById(UUID id) {
        Objects.requireNonNull(id);

        return customerRepository.findOneByKey(id);
    }

    public Optional<CustomerDTO> findOneByNickname(String nickname) {
        Objects.requireNonNull(nickname);

        return customerRepository.findOneByNickname(nickname);
    }

    public Optional<CustomerDTO> findOneByAccountId(UUID accountId) {
        Objects.requireNonNull(accountId);

        return customerRepository.findOneByAccountId(accountId);
    }

    public List<CustomerDTO> findAll() {
        return customerRepository.findAll();
    }
}
