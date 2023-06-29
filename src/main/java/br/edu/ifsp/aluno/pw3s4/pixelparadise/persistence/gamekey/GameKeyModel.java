package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game.Game;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "gamekey")
public class GameKeyModel {
    @Id
    @Column(nullable = false)
    private UUID gameId;

    @Id
    @Column(nullable = false)
    private UUID customerId;
    @Column(nullable = false)
    private long priceInCents;

    public GameKeyModel(UUID gameId, UUID customerId, long priceInCents) {
        this.gameId = gameId;
        this.customerId = customerId;
        this.priceInCents = priceInCents;
    }

    public GameKeyModel() {

    }

    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
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

