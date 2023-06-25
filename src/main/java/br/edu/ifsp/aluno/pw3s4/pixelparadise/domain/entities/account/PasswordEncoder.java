package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

public interface PasswordEncoder {
    Password encodePassword(String rawPassword);

    boolean checkPassword(Password encodedPassword, String rawPassword);
}
