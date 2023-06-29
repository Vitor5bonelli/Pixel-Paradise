package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.Game;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.GameKey;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTOConverter;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.FindCustomerUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityAlreadyExistsException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.EntityNotFoundException;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util.Notification;

import java.util.Objects;

public final class CreateGameKeyUseCase {
    private final GameKeyRepository gameKeyRepository;
    private final FindGameUseCase findGameUseCase;
    private final FindCustomerUseCase findCustomerUseCase;

    public CreateGameKeyUseCase(GameKeyRepository gameKeyRepository, FindGameUseCase findGameUseCase,
                                FindCustomerUseCase findCustomerUseCase) {
        this.gameKeyRepository = gameKeyRepository;
        this.findGameUseCase = findGameUseCase;
        this.findCustomerUseCase = findCustomerUseCase;
    }

    public void createGameKey(GameKeyDTO gameKeyDTO) {
        Objects.requireNonNull(gameKeyDTO);

        CreateGameKeyValidator validator = new CreateGameKeyValidator();
        Notification notification = validator.validate(gameKeyDTO);

        if (notification.hasMessages())
            throw new IllegalArgumentException(notification.getMessagesAsString());

        if (gameKeyRepository.existsGameKyByGameIdAndCustomerId(gameKeyDTO.gameId(), gameKeyDTO.customerId()))
            throw new EntityAlreadyExistsException("This customer already has a key for such game!");

        GameDTO gameDTO = findGameUseCase.findOneById(gameKeyDTO.gameId())
                .orElseThrow(() -> new EntityNotFoundException("Something happened while attempting to find" +
                        " the game!"));
        Game game = GameDTOConverter.getGameFromGameDTO(gameDTO);

        CustomerDTO customerDTO = findCustomerUseCase.findOneById(gameKeyDTO.customerId())
                .orElseThrow(() -> new EntityNotFoundException("Something happened while attempting to find " +
                        "the customer!"));
        Customer customer = CustomerDTOConverter.fromDTO(customerDTO);

        if (game.forbidsAgeOf(customer.getAge()))
            throw new IllegalStateException("This game is forbidden for this customer because they do not " +
                    "have enough age!");

        GameKey gameKey = new GameKey(game, customer, gameKeyDTO.priceInCents());

        gameKeyRepository.save(GameDTOConverter.gameKeyToDTO(gameKey));
    }
}
