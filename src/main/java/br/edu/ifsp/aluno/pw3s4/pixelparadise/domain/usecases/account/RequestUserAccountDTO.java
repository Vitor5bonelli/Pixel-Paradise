package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import java.util.UUID;

public record RequestUserAccountDTO(UUID id, String username, String email, String password, String ...permissions) {
}
