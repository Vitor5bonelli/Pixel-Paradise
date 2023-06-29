package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "game", uniqueConstraints = @UniqueConstraint(columnNames = {"id"}))
public class UserAccountModel {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @ElementCollection
    @CollectionTable(name = "user_permissions", joinColumns = @JoinColumn(name = "id_game"))
    @Column(name = "permission")
    private Set<String> permissions;

    public UserAccountModel(UUID id, String username, String email, String password, Set<String> permissions) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.permissions = permissions;
    }

    public UserAccountModel() {

    }

    public final UUID getId() {
        return id;
    }

    public final void setId(UUID id) {
        Objects.requireNonNull(id);

        this.id = id;
    }

    public final String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Objects.requireNonNull(username);

        if (username.isEmpty())
            throw new IllegalArgumentException("Username cannot be an empty string!");

        this.username = username;
    }

    public final String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        Objects.requireNonNull(email);

        if (email.isEmpty())
            throw new IllegalArgumentException("Email cannot be an empty string!");

        this.email = email;
    }

    public final String getPassword() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
