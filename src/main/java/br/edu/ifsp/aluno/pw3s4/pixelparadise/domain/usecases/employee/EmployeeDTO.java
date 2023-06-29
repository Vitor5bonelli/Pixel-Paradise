package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

import java.util.UUID;

public record EmployeeDTO(UUID id, String preferredName, String cpf, String phoneNumber, long wageInCents,
                          UUID accountId) {
}
