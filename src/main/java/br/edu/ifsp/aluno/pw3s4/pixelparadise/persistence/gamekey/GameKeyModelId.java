package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.gamekey;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer.CustomerModel;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameKeyModelId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel gameModel;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customerModel;

    public GameKeyModelId(GameModel gameModel, CustomerModel customerModel) {
        this.gameModel = gameModel;
        this.customerModel = customerModel;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameKeyModelId that = (GameKeyModelId) o;
        return gameModel.equals(that.gameModel) && customerModel.equals(that.customerModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameModel, customerModel);
    }
}
