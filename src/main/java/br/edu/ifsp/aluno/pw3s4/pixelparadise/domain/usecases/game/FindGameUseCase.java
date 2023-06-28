package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public final class FindGameUseCase {
    public final GameRepository gameRepository;

    public FindGameUseCase(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
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

    public List<GameDTO> findSomeByTitle(String title) {
        Objects.requireNonNull(title);

        return gameRepository.findSomeByTitle(title);
    }

    public List<GameDTO> findAll() {
        return gameRepository.findAll();
    }
}
