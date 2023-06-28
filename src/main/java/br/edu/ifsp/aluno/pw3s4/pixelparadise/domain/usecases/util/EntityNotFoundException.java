package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.util;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
