package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModelConverter;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GameKeyRepositoryImpl implements GameKeyRepository {

    private final GameKeyDAO gameKeyDAO;

    public GameKeyRepositoryImpl(GameKeyDAO gameKeyDAO) {
        this.gameKeyDAO = gameKeyDAO;
    }

    @Override
    public void save(GameKeyDTO gameKeyDTO) {

    }

    @Override
    public Optional<GameKeyDTO> findOneByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        return Optional.empty();
    }

    @Override
    public List<GameKeyDTO> findSomeByGameId(UUID gameId) {
        return null;
    }

    @Override
    public List<GameKeyDTO> findSomeByCustomerId(UUID customerId) {
        return null;
    }

    @Override
    public List<GameKeyDTO> findAll() {
        return gameKeyDAO.findAll()
                .stream()
                .map(GameKeyModelConverter::toDTO)
                .toList();
    }

    @Override
    public void deleteByGameIdAndCustomerId(UUID gameId, UUID customerId) {

    }

    @Override
    public boolean existsGameKyByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        return false;
    }
}
