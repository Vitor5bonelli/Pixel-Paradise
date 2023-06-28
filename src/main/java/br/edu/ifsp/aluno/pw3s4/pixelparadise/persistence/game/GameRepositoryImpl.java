package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GameRepositoryImpl implements GameRepository {
    private final GameDAO gameDAO;

    public GameRepositoryImpl(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }

    @Override
    public void save(GameDTO entityDTO) {
        if (gameDAO.existsById(entityDTO.id()))
            throw new EntityAlreadyExistsException("There already is such game!");
        gameDAO.save(GameModelConverter.fromDTO(entityDTO));
    }

    @Override
    public Optional<GameDTO> findOneByKey(UUID key) {
        return gameDAO.findById(key)
                .map(GameModelConverter::toDTO);
    }

    @Override
    public Optional<GameDTO> findOneByTitleAndReleaseDate(String title, LocalDate releaseDate) {
        GameModel gameModel = new GameModel();
        gameModel.setTitle(title);
        gameModel.setReleaseDate(releaseDate);

        return gameDAO.findOne(Example.of(gameModel))
                .map(GameModelConverter::toDTO);
    }

    @Override
    public List<GameDTO> findSomeByTitle(String title) {
        GameModel gameModel = new GameModel();
        gameModel.setTitle(title);

        return gameDAO.findAll(Example.of(gameModel))
                .stream()
                .map(GameModelConverter::toDTO)
                .toList();
    }

    @Override
    public List<GameDTO> findAll() {
        return gameDAO.findAll()
                .stream()
                .map(GameModelConverter::toDTO)
                .toList();
    }

    @Override
    public void update(GameDTO entityDTO) {
        if (!gameDAO.existsById(entityDTO.id()))
            throw new EntityNotFoundException("There is not such game!");
        gameDAO.save(GameModelConverter.fromDTO(entityDTO));
    }

    @Override
    public void deleteByKey(UUID key) {
        gameDAO.deleteById(key);
    }

    @Override
    public boolean existsByKey(UUID key) {
        return gameDAO.existsById(key);
    }

    @Override
    public boolean existsByTitleAndReleaseDate(String title, LocalDate releaseDate) {
        GameModel gameModel = new GameModel();
        gameModel.setTitle(title);
        gameModel.setReleaseDate(releaseDate);

        return gameDAO.exists(Example.of(gameModel));
    }
}
