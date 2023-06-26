package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import java.time.LocalDate;
import java.util.UUID;

public record CustomerDTO(UUID id, String nickname, LocalDate dateOfBirth) {
}
