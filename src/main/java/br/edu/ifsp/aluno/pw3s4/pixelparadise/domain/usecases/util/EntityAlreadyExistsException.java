package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util;

public class EntityAlreadyExistsException extends RuntimeException {
    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
