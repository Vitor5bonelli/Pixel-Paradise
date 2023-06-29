package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
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
        Objects.requireNonNull(gameKeyDTO);

        if (existsGameKyByGameIdAndCustomerId(gameKeyDTO.gameId(), gameKeyDTO.customerId()))
            throw new EntityAlreadyExistsException("There already is a key for such game and customer!");

        gameKeyDAO.save(GameKeyModelConverter.fromDTO(gameKeyDTO));
    }

    @Override
    public Optional<GameKeyDTO> findOneByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        Objects.requireNonNull(gameId);
        Objects.requireNonNull(customerId);

        GameKeyModel gameKeyModel = new GameKeyModel(gameId, customerId, null);

        return gameKeyDAO.findOne(Example.of(gameKeyModel))
                .map(GameKeyModelConverter::toDTO);
    }

    @Override
    public List<GameKeyDTO> findSomeByGameId(UUID gameId) {
        Objects.requireNonNull(gameId);

        GameKeyModel gameKeyModel = new GameKeyModel();
        gameKeyModel.setGameId(gameId);

        return gameKeyDAO.findAll(Example.of(gameKeyModel))
                .stream()
                .map(GameKeyModelConverter::toDTO)
                .toList();
    }

    @Override
    public List<GameKeyDTO> findSomeByCustomerId(UUID customerId) {
        Objects.requireNonNull(customerId);

        GameKeyModel gameKeyModel = new GameKeyModel();
        gameKeyModel.setCustomerId(customerId);

        return gameKeyDAO.findAll(Example.of(gameKeyModel))
                .stream()
                .map(GameKeyModelConverter::toDTO)
                .toList();
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
        Objects.requireNonNull(gameId);
        Objects.requireNonNull(customerId);

        GameKeyModel gameKeyModel = findOneByGameIdAndCustomerId(gameId, customerId)
                .map(GameKeyModelConverter::fromDTO)
                .orElseThrow(() -> new EntityNotFoundException("There is not such game key!"));

        gameKeyDAO.delete(gameKeyModel);
    }

    @Override
    public boolean existsGameKyByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        GameKeyModel gameKeyModel = new GameKeyModel(gameId, customerId, null);

        return gameKeyDAO.exists(Example.of(gameKeyModel));
    }
}
