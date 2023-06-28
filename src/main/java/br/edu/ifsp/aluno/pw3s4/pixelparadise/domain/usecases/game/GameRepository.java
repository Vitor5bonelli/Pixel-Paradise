package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Repository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface GameRepository extends Repository<UUID, GameDTO> {
    Optional<GameDTO> findOneByTitle(String title);

    boolean existsByTitleAndReleaseDate(String title, LocalDate releaseDate);
}
