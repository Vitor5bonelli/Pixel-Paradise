package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameKeyRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameRepository;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModelConverter;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModelConverter;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GameKeyRepositoryImpl implements GameKeyRepository {

    private final GameKeyDAO gameKeyDAO;
    private final GameRepository gameRepository;
    private final CustomerRepository customerRepository;

    public GameKeyRepositoryImpl(GameKeyDAO gameKeyDAO, GameRepository gameRepository,
                                 CustomerRepository customerRepository) {
        this.gameKeyDAO = gameKeyDAO;
        this.gameRepository = gameRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(GameKeyDTO gameKeyDTO) {
        Objects.requireNonNull(gameKeyDTO);

        if (existsGameKyByGameIdAndCustomerId(gameKeyDTO.gameId(), gameKeyDTO.customerId()))
            throw new EntityAlreadyExistsException("There already is a key for such game and customer!");

        GameModel gameModel = findGameModel(gameKeyDTO.gameId());
        CustomerModel customerModel = findCustomerModel(gameKeyDTO.customerId());

        gameKeyDAO.save(GameKeyModelConverter.fromDTO(gameKeyDTO, gameModel, customerModel));
    }

    @Override
    public Optional<GameKeyDTO> findOneByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        Objects.requireNonNull(gameId);
        Objects.requireNonNull(customerId);

        GameModel gameModel = findGameModel(gameId);
        CustomerModel customerModel = findCustomerModel(customerId);
        GameKeyModel gameKeyModel = new GameKeyModel(gameModel, customerModel, null);

        return gameKeyDAO.findOne(Example.of(gameKeyModel))
                .map(GameKeyModelConverter::toDTO);
    }

    @Override
    public List<GameKeyDTO> findSomeByGameId(UUID gameId) {
        Objects.requireNonNull(gameId);

        GameKeyModel gameKeyModel = new GameKeyModel();
        GameModel gameModel = findGameModel(gameId);
        gameKeyModel.setGameModel(gameModel);

        return gameKeyDAO.findAll(Example.of(gameKeyModel))
                .stream()
                .map(GameKeyModelConverter::toDTO)
                .toList();
    }

    @Override
    public List<GameKeyDTO> findSomeByCustomerId(UUID customerId) {
        Objects.requireNonNull(customerId);

        GameKeyModel gameKeyModel = new GameKeyModel();
        CustomerModel customerModel = findCustomerModel(customerId);
        gameKeyModel.setCustomerModel(customerModel);

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

        GameModel gameModel = findGameModel(gameId);
        CustomerModel customerModel = findCustomerModel(customerId);
        GameKeyModel gameKeyModel = findOneByGameIdAndCustomerId(gameId, customerId)
                .map(dto -> GameKeyModelConverter.fromDTO(dto, gameModel, customerModel))
                .orElseThrow(() -> new EntityNotFoundException("There is not such game key!"));

        gameKeyDAO.delete(gameKeyModel);
    }

    @Override
    public boolean existsGameKyByGameIdAndCustomerId(UUID gameId, UUID customerId) {
        GameModel gameModel = findGameModel(gameId);
        CustomerModel customerModel = findCustomerModel(customerId);
        GameKeyModel gameKeyModel = new GameKeyModel(gameModel, customerModel, null);

        return gameKeyDAO.exists(Example.of(gameKeyModel));
    }

    private GameModel findGameModel(UUID gameId) {
        GameDTO gameDTO = gameRepository.findOneByKey(gameId)
                .orElseThrow(() -> new EntityNotFoundException("There is not such game!"));

        return GameModelConverter.fromDTO(gameDTO);
    }

    private CustomerModel findCustomerModel(UUID customerId) {
        CustomerDTO customerDTO = customerRepository.findOneByKey(customerId)
                .orElseThrow(() -> new EntityNotFoundException("There is not such customer!"));

        return CustomerModelConverter.fromDTO(customerDTO);
    }
}
