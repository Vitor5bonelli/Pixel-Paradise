package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;

public final class CustomerModelConverter {
    public static CustomerModel fromDTO(CustomerDTO customerDTO) {
        if (customerDTO == null)
            return null;
        return new CustomerModel(customerDTO.id(), customerDTO.nickname(), customerDTO.dateOfBirth());
    }

    public static CustomerDTO toDTO(CustomerModel customerModel) {
        return null;
    }
}
