package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.Game;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.GameGenre;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.GameKey;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.GamePlatform;

import java.util.List;

public final class GameDTOConverter {
    public static Game getGameFromCreateGameDTO(CreateGameDTO createGameDTO) {
        Game game = new Game(createGameDTO.title(), createGameDTO.releaseDate(), createGameDTO.minimumAge(),
                createGameDTO.priceInCents());
        createGameDTO.genres()
                .stream()
                .map(GameGenre::of)
                .forEach(game::addGenre);
        createGameDTO.platforms()
                .stream()
                .map(GamePlatform::of)
                .forEach(game::addPlatform);

        return game;
    }

    public static Game getGameFromGameDTO(GameDTO gameDTO) {
        Game game = new Game(gameDTO.id(), gameDTO.title(), gameDTO.releaseDate(), gameDTO.minimumAge(),
                gameDTO.priceInCents());
        gameDTO.platforms().stream()
                .map(GamePlatform::of)
                .forEach(game::addPlatform);
        gameDTO.genres().stream()
                .map(GameGenre::of)
                .forEach(game::addGenre);

        return game;
    }

    public static GameDTO gameToDTO(Game game) {
        List<String> genresAsString = game.getGenresList().stream()
                .map(GameGenre::toString)
                .toList();
        List<String> platformsAsString = game.getPlatformsList().stream()
                .map(GamePlatform::toString)
                .toList();

        return new GameDTO(game.getId(), game.getTitle(), game.getReleaseDate(), game.getMinimumAge(),
                    game.getPriceInCents(), platformsAsString, genresAsString);
    }

    public static GameKeyDTO gameKeyToDTO(GameKey gameKey) {
        return new GameKeyDTO(gameKey.getGame().getId(), gameKey.getCustomer().getId(), gameKey.getPriceInCents());
    }
}
