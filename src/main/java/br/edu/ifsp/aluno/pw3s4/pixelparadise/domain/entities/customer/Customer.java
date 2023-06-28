package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Customer {
    private static final int MINIMUM_AGE = 16;
    private UUID id;
    private String nickname;
    private LocalDate dateOfBirth;

    public Customer(UUID id, String nickname, LocalDate dateOfBirth) {
        this.id = id;
        setNickname(nickname);
        setDateOfBirth(dateOfBirth);
    }

    public Customer(CustomerDTO values){
        this.id = values.id();
        setNickname(values.nickname());
        setDateOfBirth(values.dateOfBirth());
    }

    public Customer(String nickname, LocalDate dateOfBirth) {
        this(null, nickname, dateOfBirth);
    }

    public final int getAge() {
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(UUID id) {
        Objects.requireNonNull(id);

        this.id = id;
    }

    public final String getNickname() {
        return nickname;
    }

    public final void setNickname(String nickname) {
        Objects.requireNonNull(nickname);

        if (nickname.isEmpty())
            throw new IllegalArgumentException("Nickname cannot be an empty string!");

        this.nickname = nickname;
    }

    public final LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public final void setDateOfBirth(LocalDate dateOfBirth) {
        Objects.requireNonNull(dateOfBirth);

        if (LocalDate.now().getYear() - dateOfBirth.getYear() < MINIMUM_AGE)
            throw new IllegalArgumentException("The customer must have at least age of " + MINIMUM_AGE + "!");

        this.dateOfBirth = dateOfBirth;
    }
}
