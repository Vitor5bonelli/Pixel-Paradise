package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import jakarta.persistence.*;

import java.util.UUID;

// todo: corrigir as fks
@Entity
@Table(name = "game_key")
public class GameKeyModel {
    @Id
    @Column(nullable = false)
    private UUID gameId;
    @Id
    @Column(nullable = false)
    private UUID customerId;
    @Column(nullable = false)
    private Long priceInCents;

    public GameKeyModel(UUID gameId, UUID customerId, Long priceInCents) {
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

