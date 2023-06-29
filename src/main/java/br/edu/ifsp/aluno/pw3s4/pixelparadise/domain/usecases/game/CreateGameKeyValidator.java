package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Validator;

import java.util.Objects;

public class CreateGameKeyValidator extends Validator<GameKeyDTO> {
    @Override
    public Notification validate(GameKeyDTO keyDTO) {
        Objects.requireNonNull(keyDTO);

        Notification notification = new Notification();

        if (keyDTO.gameId() == null)
            notification.addMessage("The game id is a mandatory data!");
        if (keyDTO.customerId() == null)
            notification.addMessage("The customer id is a mandatory data!");
        if (keyDTO.priceInCents() < 0)
            notification.addMessage("The price in cents must be a non-negative number!");

        return notification;
    }
}
