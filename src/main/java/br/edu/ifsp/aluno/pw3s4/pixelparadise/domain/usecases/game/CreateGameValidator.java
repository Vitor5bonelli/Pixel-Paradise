package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Validator;

import java.util.Objects;

public class CreateGameValidator extends Validator<CreateGameDTO> {
    @Override
    public Notification validate(CreateGameDTO createGameDTO) {
        Objects.requireNonNull(createGameDTO);

        Notification notification = new Notification();

        if (isNullOrEmptyString(createGameDTO.title()))
            notification.addMessage("Game title cannot be null or empty!");
        if (createGameDTO.releaseDate() == null)
            notification.addMessage("Release date is a mandatory data!");
        if (createGameDTO.platforms() == null || createGameDTO.platforms().isEmpty())
            notification.addMessage("At least one platform is needed!");
        if (createGameDTO.genres() == null || createGameDTO.genres().isEmpty())
            notification.addMessage("At least one genre is needed!");

        return notification;
    }
}
