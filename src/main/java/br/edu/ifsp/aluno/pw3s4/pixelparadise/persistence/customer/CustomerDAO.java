package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerDAO extends JpaRepository<CustomerModel, UUID> {
}
