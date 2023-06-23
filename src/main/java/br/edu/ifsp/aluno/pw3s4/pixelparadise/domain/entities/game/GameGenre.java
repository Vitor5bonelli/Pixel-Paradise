package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class GameGenre {
    private static final Map<String, GameGenre> instances = new HashMap<>();
    private final String description;

    private GameGenre(String description) {
        this.description = description;
    }

    public static GameGenre of(String description) {
        Objects.requireNonNull(description);

        String upperCaseDescription = description.strip().toUpperCase();

        if (upperCaseDescription.isEmpty())
            throw new IllegalArgumentException("Genre description cannot be an empty string!");

        if (!instances.containsKey(upperCaseDescription))
            instances.put(upperCaseDescription, new GameGenre(upperCaseDescription));

        return instances.get(upperCaseDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameGenre gameGenre = (GameGenre) o;
        return description.equals(gameGenre.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description);
    }

    @Override
    public String toString() {
        return description;
    }
}
