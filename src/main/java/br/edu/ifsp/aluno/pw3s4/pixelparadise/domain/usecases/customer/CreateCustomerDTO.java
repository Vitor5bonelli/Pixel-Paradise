package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer;

import java.time.LocalDate;

public record CreateCustomerDTO(String nickname, LocalDate dateOfBirth) {
}
