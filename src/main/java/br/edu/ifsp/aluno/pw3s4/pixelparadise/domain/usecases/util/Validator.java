package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util;

public abstract class Validator<T> {
    public abstract Notification validate(T type);

    public boolean isNullOrEmptyString(String string) {
        return string == null || string.isEmpty();
    }
}
