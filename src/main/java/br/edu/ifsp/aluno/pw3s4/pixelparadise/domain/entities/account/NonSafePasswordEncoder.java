package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

import org.springframework.stereotype.Component;

@Component
public class NonSafePasswordEncoder implements PasswordEncoder {
    @Override
    public Password encodePassword(String rawPassword) {
        return Password.createPassword(rawPassword);
    }

    @Override
    public boolean checkPassword(Password encodedPassword, String rawPassword) {
        return encodePassword(rawPassword).equals(encodedPassword);
    }
}
