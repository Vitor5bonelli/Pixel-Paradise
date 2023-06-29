package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class UserAccount {
    private UUID id;
    private String username;
    private String email;
    private Password password;
    private final Set<UserPermission> permissions = new HashSet<>();

    public UserAccount(UUID id, String username, String email, Password password) {
        this.id = id;
        setUsername(username);
        setEmail(email);
        setPassword(password);
    }

    public UserAccount(String username, String email, Password password) {
        this(null, username, email, password);
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
        return password.toString();
    }

    public final void setPassword(Password password) {
        Objects.requireNonNull(password);

        this.password = password;
    }
}
