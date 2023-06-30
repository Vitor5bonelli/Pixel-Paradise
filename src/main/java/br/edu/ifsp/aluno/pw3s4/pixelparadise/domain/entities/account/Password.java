package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

import java.util.Objects;

public final class Password {
    private final String password;

    private Password(String password) {
        this.password = password;
    }

    static Password createPassword(String password) {
        Objects.requireNonNull(password);

        return new Password(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password1 = (Password) o;
        return Objects.equals(password, password1.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

    @Override
    public String toString() {
        return password;
    }
}
