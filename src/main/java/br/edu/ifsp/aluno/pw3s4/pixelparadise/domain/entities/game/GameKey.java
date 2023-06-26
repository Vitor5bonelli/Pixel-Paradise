package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;

import java.util.Objects;

public class GameKey {
    private Game game;
    private Customer customer;
    private long priceInCents;

    public GameKey(Game game, Customer customer, long priceInCents) {
        setGame(game);
        setCustomer(customer);
        setPriceInCents(priceInCents);
    }

    public final Game getGame() {
        return game;
    }

    private void setGame(Game game) {
        Objects.requireNonNull(game);

        this.game = game;
    }

    public final Customer getCustomer() {
        return customer;
    }

    private void setCustomer(Customer customer) {
        Objects.requireNonNull(customer);

        this.customer = customer;
    }

    public final long getPriceInCents() {
        return priceInCents;
    }

    private void setPriceInCents(long priceInCents) {
        if (priceInCents < 0)
            throw new IllegalArgumentException("Price must be a non-negative number!");
        this.priceInCents = priceInCents;
    }
}
