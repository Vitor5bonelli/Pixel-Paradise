package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.functionary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="employee")
public class EmployeeModel {
    @Id
    private UUID id;

    @Column
    private String preferredName;

    @Column
    private String CPF;

    @Column
    private String phone;

    @Column
    private long wageInCents;

    public EmployeeModel(UUID id, String preferredName, String CPF, String phone, long wageInCents) {
        this.id = id;
        this.preferredName = preferredName;
        this.CPF = CPF;
        this.phone = phone;
        this.wageInCents = wageInCents;
    }

    public EmployeeModel(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getWageInCents() {
        return wageInCents;
    }

    public void setWageInCents(long wageInCents) {
        this.wageInCents = wageInCents;
    }
}
