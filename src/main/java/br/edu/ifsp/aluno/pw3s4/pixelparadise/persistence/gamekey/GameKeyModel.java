package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;
import jakarta.persistence.*;

import java.util.UUID;

// todo: corrigir as fks
@Entity
@Table(name = "game_key")
public class GameKeyModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "gameId")
    private GameModel gameModel;
    @Id
    @ManyToOne
    @JoinColumn(name = "customerId")
    private CustomerModel customerModel;
    @Column(nullable = false)
    private Long priceInCents;

    public GameKeyModel(GameModel gameModel, CustomerModel customerModel, Long priceInCents) {
        this.gameModel = gameModel;
        this.customerModel = customerModel;
        this.priceInCents = priceInCents;
    }

    public GameKeyModel() {

    }

    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public CustomerModel getCustomerModel() {
        return customerModel;
    }

    public void setCustomerModel(CustomerModel customerModel) {
        this.customerModel = customerModel;
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

