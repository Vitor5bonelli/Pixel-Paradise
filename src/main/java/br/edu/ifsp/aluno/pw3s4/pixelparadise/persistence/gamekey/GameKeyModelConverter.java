package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;

public class GameKeyModelConverter {

    public static GameKeyModel fromDTO(GameKeyDTO gameKeyDTO) {
        if (gameKeyDTO == null)
            return null;
        return new GameKeyModel(gameKeyDTO.gameId(), gameKeyDTO.customerId(), gameKeyDTO.priceInCents());
    }

    public static GameKeyDTO toDTO(GameKeyModel gameKeyModel) {
        if (gameKeyModel == null)
            return null;
        return new GameKeyDTO(gameKeyModel.getGameId(), gameKeyModel.getCustomerId(), gameKeyModel.getPriceInCents());
    }
}
