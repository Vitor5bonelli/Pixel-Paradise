package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Validator;

import java.util.Objects;

public class CreateCustomerValidator extends Validator<CreateCustomerDTO> {
    @Override
    public Notification validate(CreateCustomerDTO createCustomerDTO) {
        Objects.requireNonNull(createCustomerDTO);

        Notification notification = new Notification();

        if (isNullOrEmptyString(createCustomerDTO.nickname()))
            notification.addMessage("Nickname cannot be null or empty!");
        if (createCustomerDTO.dateOfBirth() == null)
            notification.addMessage("Date of birth is a mandatory data!");

        return notification;
    }
}
