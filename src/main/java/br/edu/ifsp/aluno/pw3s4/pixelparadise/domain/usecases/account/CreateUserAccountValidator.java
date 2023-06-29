package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Validator;

import java.util.Objects;

public class CreateUserAccountValidator extends Validator<CreateUserAccountDTO> {
    @Override
    public Notification validate(CreateUserAccountDTO createUserAccountDTO) {
        Objects.requireNonNull(createUserAccountDTO);

        Notification notification = new Notification();

        if (isNullOrEmptyString(createUserAccountDTO.username()))
            notification.addMessage("Username cannot be null or empty!");
        if (isNullOrEmptyString(createUserAccountDTO.password()) || createUserAccountDTO.password().length() < 8)
            notification.addMessage("Password cannot be null and must have at least 8 characters!");

        return notification;
    }
}
