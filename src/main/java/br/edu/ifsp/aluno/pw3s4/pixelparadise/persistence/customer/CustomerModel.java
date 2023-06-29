package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="customer")
public class CustomerModel {
    @Id
    private UUID id;
    @Column
    private String nickname;
    @Column
    private LocalDate dateOfBirth;

    public CustomerModel(UUID id, String nickname, LocalDate dateOfBirth) {
        this.id = id;
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
    }

    public CustomerModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
