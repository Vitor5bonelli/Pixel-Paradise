package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.GameKey;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.FindCustomerUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public final class FindGameUseCase {
    private final GameRepository gameRepository;
    private final GameKeyRepository gameKeyRepository;
    private final FindCustomerUseCase findCustomerUseCase;

    public FindGameUseCase(GameRepository gameRepository, GameKeyRepository gameKeyRepository,
                           FindCustomerUseCase findCustomerUseCase) {
        this.gameRepository = gameRepository;
        this.gameKeyRepository = gameKeyRepository;
        this.findCustomerUseCase = findCustomerUseCase;
    }

    public Optional<GameDTO> findOneById(UUID id) {
        Objects.requireNonNull(id);

        return gameRepository.findOneByKey(id);
    }

    public Optional<GameDTO> findOneByTitleAndReleaseDate(String title, LocalDate releaseDate) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(releaseDate);

        return gameRepository.findOneByTitleAndReleaseDate(title, releaseDate);
    }

    public Optional<GameKeyDTO> findOneGameKeyByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        findOneById(gameId).orElseThrow(() -> new EntityNotFoundException("There is not such game"));
        findCustomerUseCase.findOneById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("There is not such customer!"));

        return gameKeyRepository.findOneByGameIdAndCustomerId(gameId, customerId);
    }

    public List<GameDTO> findSomeByTitle(String title) {
        Objects.requireNonNull(title);

        return gameRepository.findSomeByTitle(title);
    }

    public List<GameKeyDTO> findSomeGameKeyByCustomerId(UUID customerId) {
        findCustomerUseCase.findOneById(customerId)
                .orElseThrow(() -> new EntityNotFoundException("There is not such customer!"));

        return gameKeyRepository.findSomeByCustomerId(customerId);
    }

    public List<GameKeyDTO> findSomeGameKeyByGameId(UUID gameId) {
        findOneById(gameId).orElseThrow(() -> new EntityNotFoundException("There is not such game!"));

        return gameKeyRepository.findSomeByGameId(gameId);
    }

    public List<GameDTO> findAll() {
        return gameRepository.findAll();
    }

    public List<GameKeyDTO> findAllGameKey() {
        return gameKeyRepository.findAll();
    }
}
