package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee;

public record CreateEmployeeDTO(String preferredName, String cpf, String phoneNumber, long wageInCents) {
}
