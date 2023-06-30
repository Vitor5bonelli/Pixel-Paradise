package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.functionary;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeDAO extends JpaRepository<EmployeeModel, UUID> {
}
