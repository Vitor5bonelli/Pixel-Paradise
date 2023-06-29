package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount.UserAccountModel;

public final class CustomerModelConverter {
    public static CustomerModel fromDTO(CustomerDTO customerDTO, UserAccountModel userAccountModel) {
        if (customerDTO == null)
            return null;
        return new CustomerModel(customerDTO.id(), customerDTO.nickname(), customerDTO.dateOfBirth(), userAccountModel);
    }

    public static CustomerDTO toDTO(CustomerModel customerModel) {
        return new CustomerDTO(customerModel.getId(), customerModel.getNickname(), customerModel.getDateOfBirth(),
                customerModel.getUserAccountModel().getId());
    }
}
