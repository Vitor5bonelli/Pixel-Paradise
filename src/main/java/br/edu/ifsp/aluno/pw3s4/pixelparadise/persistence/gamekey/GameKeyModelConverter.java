package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;

public class GameKeyModelConverter {

    public static GameKeyModel fromDTO(GameKeyDTO gameKeyDTO, GameModel gameModel, CustomerModel customerModel) {
        if (gameKeyDTO == null)
            return null;
        return new GameKeyModel(new GameKeyModelId(gameModel, customerModel), gameKeyDTO.priceInCents());
    }

    public static GameKeyDTO toDTO(GameKeyModel gameKeyModel) {
        if (gameKeyModel == null)
            return null;
        return new GameKeyDTO(gameKeyModel.getGameModel().getId(), gameKeyModel.getCustomerModel().getId(),
                        gameKeyModel.getPriceInCents());
    }
}
