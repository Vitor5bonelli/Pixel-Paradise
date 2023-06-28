package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;

public final class GameModelConverter {
    public static GameModel fromDTO(GameDTO gameDTO) {
        if (gameDTO == null)
            return null;
        return new GameModel(gameDTO.id(), gameDTO.title(), gameDTO.releaseDate(), gameDTO.minimumAge(),
                    gameDTO.priceInCents(), gameDTO.platforms(), gameDTO.genres());
    }

    public static GameDTO toDTO(GameModel gameModel) {
        if (gameModel == null)
            return null;
        return new GameDTO(gameModel.getId(), gameModel.getTitle(), gameModel.getReleaseDate(),
                            gameModel.getMinimumAge(), gameModel.getPriceInCents(), gameModel.getPlatforms(),
                            gameModel.getGenres());
    }
}
