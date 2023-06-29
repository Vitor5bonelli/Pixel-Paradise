package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserPermission;
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
    private final Set<UserPermission> permissions = new HashSet<>();

    public UserAccountModel(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserAccountModel() {

    }

    public final boolean hasPermission(UserPermission permission) {
        Objects.requireNonNull(permission);

        return permissions.contains(permission);
    }

    public final void grantPermission(UserPermission permission) {
        Objects.requireNonNull(permission);

        permissions.add(permission);
    }

    public final void revokePermission(UserPermission permission) {
        Objects.requireNonNull(permission);

        permissions.remove(permission);
    }

    public final Set<UserPermission> getPermissionsSet() {
        return Set.copyOf(permissions);
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

    private void setUsername(String username) {
        Objects.requireNonNull(username);

        if (username.isEmpty())
            throw new IllegalArgumentException("Username cannot be an empty string!");

        this.username = username;
    }

    public final String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        Objects.requireNonNull(email);

        if (email.isEmpty())
            throw new IllegalArgumentException("Email cannot be an empty string!");

        this.email = email;
    }

    public final String getPasswordAsString() {
        return password;
    }

    public final void setPassword(String password) {
        this.password = password;
    }

}
