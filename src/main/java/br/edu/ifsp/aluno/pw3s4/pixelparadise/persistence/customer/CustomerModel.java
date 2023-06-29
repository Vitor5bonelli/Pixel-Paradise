package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount.UserAccountModel;
import jakarta.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "account_id")
    private UserAccountModel userAccountModel;

    public CustomerModel(UUID id, String nickname, LocalDate dateOfBirth, UserAccountModel userAccountModel) {
        this.id = id;
        this.nickname = nickname;
        this.dateOfBirth = dateOfBirth;
        this.userAccountModel = userAccountModel;
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

    public UserAccountModel getUserAccountModel() {
        return userAccountModel;
    }

    public void setUserAccountModel(UserAccountModel userAccountModel) {
        this.userAccountModel = userAccountModel;
    }
}
