package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

import java.util.Objects;

final class Password {
    private final String password;

    private Password(String password) {
        this.password = password;
    }

    static Password createPassword(String password) {
        Objects.requireNonNull(password);

        return new Password(password);
    }

    @Override
    public String toString() {
        return password;
    }
}
