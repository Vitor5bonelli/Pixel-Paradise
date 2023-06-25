package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.util.CPF;

import java.util.Objects;
import java.util.UUID;

public class Employee {
    private UUID id;
    private String preferredName;
    private final CPF cpf;
    private String phoneNumber;
    private long wageInCents;

    public Employee(UUID id, String preferredName, CPF cpf, String phoneNumber, long wageInCents) {
        Objects.requireNonNull(cpf);

        this.id = id;
        setPreferredName(preferredName);
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        setWageInCents(wageInCents);
    }

    public Employee(String preferredName, CPF cpf, String phoneNumber, long wageInCents) {
        this(null, preferredName, cpf, phoneNumber, wageInCents);
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(UUID id) {
        Objects.requireNonNull(id);

        this.id = id;
    }

    public final String getPreferredName() {
        return preferredName;
    }

    public final void setPreferredName(String preferredName) {
        Objects.requireNonNull(preferredName);

        if (preferredName.isEmpty())
            throw new IllegalArgumentException("The preferred name cannot be an empty string!");

        this.preferredName = preferredName;
    }

    public final CPF getCpf() {
        return cpf;
    }

    public final String getPhoneNumber() {
        return phoneNumber;
    }

    public final void setPhoneNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber);

        this.phoneNumber = phoneNumber;
    }

    public final long getWageInCents() {
        return wageInCents;
    }

    public final void setWageInCents(long wageInCents) {
        if (wageInCents <= 0)
            throw new IllegalArgumentException("Wage must be a positive value!");

        this.wageInCents = wageInCents;
    }
}
