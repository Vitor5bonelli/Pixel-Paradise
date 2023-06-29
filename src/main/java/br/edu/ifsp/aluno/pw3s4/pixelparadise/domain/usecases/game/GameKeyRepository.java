package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameKeyRepository {
    void save(GameKeyDTO gameKeyDTO);

    Optional<GameKeyDTO> findOneByGameIdAndCustomerId(UUID gameId, UUID customerId);

    List<GameKeyDTO> findSomeByGameId(UUID gameId);

    List<GameKeyDTO> findSomeByCustomerId(UUID customerId);

    List<GameKeyDTO> findAll();

    void deleteByGameIdAndCustomerId(UUID gameId, UUID customerId);

    boolean existsGameKyByGameIdAndCustomerId(UUID gameId, UUID customerId);
}
