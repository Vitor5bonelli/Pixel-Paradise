package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;
import jakarta.persistence.*;

import java.util.UUID;

// todo: corrigir as fks
@Entity
@Table(name = "game_key")
public class GameKeyModel {
    @EmbeddedId
    private GameKeyModelId id;
    @Column(nullable = false)
    private Long priceInCents;

    public GameKeyModel(GameKeyModelId id, Long priceInCents) {
        this.id = id;
        this.priceInCents = priceInCents;
    }

    public GameKeyModel() {

    }

    public GameModel getGameModel() {
        return id.getGameModel();
    }

    public CustomerModel getCustomerModel() {
        return id.getCustomerModel();
    }

    public void setId(GameKeyModelId id) {
        this.id = id;
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

