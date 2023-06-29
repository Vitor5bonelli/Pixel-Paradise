package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Validator;

import java.util.Objects;

public class CreateEmployeeValidator extends Validator<CreateEmployeeDTO> {
    @Override
    public Notification validate(CreateEmployeeDTO createEmployeeDTO) {
        Objects.requireNonNull(createEmployeeDTO);

        Notification notification = new Notification();

        if (isNullOrEmptyString(createEmployeeDTO.preferredName()))
            notification.addMessage("Preferred name is a mandatory data!");
        if (isNullOrEmptyString(createEmployeeDTO.phoneNumber()))
            notification.addMessage("Phone number cannot be null or empty");
        if (isNullOrEmptyString(createEmployeeDTO.cpf()))
            notification.addMessage("CPF is a mandatory data!");
        if (createEmployeeDTO.wageInCents() <= 0)
            notification.addMessage("Employee's wage cannot be zero or lesser!");

        return notification;
    }
}
