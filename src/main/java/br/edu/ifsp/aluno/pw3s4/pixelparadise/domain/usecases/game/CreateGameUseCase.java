package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.Game;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

public final class CreateGameUseCase {
    private final GameRepository gameRepository;

    public CreateGameUseCase(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public UUID createGame(CreateGameDTO createGameDTO) {
        Objects.requireNonNull(createGameDTO);

        CreateGameValidator validator = new CreateGameValidator();
        Notification notification = validator.validate(createGameDTO);

        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());

        Game game = GameDTOConverter.getGameFromCreateGameDTO(createGameDTO);

        if (!gameRepository.existsByTitleAndReleaseDate(game.getTitle(), game.getReleaseDate()))
            throw new EntityAlreadyExistsException("There already is a game with such title!");

        UUID gameId = UUID.randomUUID();
        game.setId(gameId);

        gameRepository.save(GameDTOConverter.gameToDTO(game));

        return gameId;
    }
}
