package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GamePlatform {
    private static final Map<String, GamePlatform> instances = new HashMap<>();
    private final String name;

    private GamePlatform(String name) {
        this.name = name;
    }

    public static GamePlatform of(String name) {
        Objects.requireNonNull(name);

        String upperCaseName = name.strip().toUpperCase();

        if (upperCaseName.isEmpty())
            throw new IllegalArgumentException("Platform name cannot be an empty string!");

        if (!instances.containsKey(upperCaseName))
            instances.put(upperCaseName, new GamePlatform(upperCaseName));

        return instances.get(upperCaseName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlatform that = (GamePlatform) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
