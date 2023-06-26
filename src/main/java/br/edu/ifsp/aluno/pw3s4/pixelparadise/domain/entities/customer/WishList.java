package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class WishList {
    private Customer customer;
    private final Map<UUID, Game> wishGames = new HashMap<>();

    public WishList(Customer customer) {
        setCustomer(customer);
    }

    public final boolean isEmpty() {
        return wishGames.isEmpty();
    }

    public final boolean hasGame(Game game) {
        Objects.requireNonNull(game);

        return wishGames.containsKey(game.getId());
    }

    public final void addGame(Game game) {
        Objects.requireNonNull(game);

        if (hasGame(game))
            return;

        wishGames.put(game.getId(), game);
    }

    public final void addSeveralGames(Game ...games) {
        Arrays.stream(games)
                .forEach(this::addGame);
    }

    public final void removeGame(Game game) {
        Objects.requireNonNull(game);

        wishGames.remove(game.getId());
    }

    public final void removeAllGames() {
        wishGames.clear();
    }

    public final List<Game> getWishGamesList() {
        return new ArrayList<>(wishGames.values());
    }

    public final Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        Objects.requireNonNull(customer);

        this.customer = customer;
    }
}
