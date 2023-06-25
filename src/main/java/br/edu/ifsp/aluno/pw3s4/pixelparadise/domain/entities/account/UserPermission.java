package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

import java.util.Arrays;

public enum UserPermission {
    LOGIN("login"),
    CREATE_GAME("createGame"),
    UPDATE_GAME("updateGame"),
    RETRIEVE_ANY_GAME("retrieveAnyGame"),
    DELETE_GAME("excludeGame"),
    PURCHASE_GAME("purchaseGame"),
    RETRIEVE_PURCHASED_GAMES("retrievePurchaseGames"),
    CREATE_EMPLOYEE("createEmployee"),
    UPDATE_EMPLOYEE("updateEmployee"),
    RETRIEVE_EMPLOYEE("retrieveEmployee"),
    DELETE_EMPLOYEE("excludeEmployee");

    private final String description;

    UserPermission(String description) {
        this.description = description;
    }

    public static UserPermission fromString(String value) {
        return Arrays.stream(UserPermission.values())
                .filter(permission -> permission.description.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The specified value is not a valid permission!"));
    }

    @Override
    public String toString() {
        return description;
    }
}
