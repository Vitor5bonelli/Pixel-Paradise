package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;

public final class CustomerDTOConverter {
    public static Customer fromCreateCustomerDTO(CreateCustomerDTO createCustomerDTO) {
        return new Customer(createCustomerDTO.nickname(), createCustomerDTO.dateOfBirth());
    }

    public static CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(customer.getId(), customer.getNickname(), customer.getDateOfBirth(),
                customer.getAccount().getId());
    }
}
