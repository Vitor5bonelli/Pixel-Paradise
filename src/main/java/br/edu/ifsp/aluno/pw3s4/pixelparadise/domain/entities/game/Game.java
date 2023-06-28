package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.game;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.UUID;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

public class Game {
    private UUID id;
    private String title;
    private LocalDate releaseDate;
    private int minimumAge;
    private long priceInCents;
    private final Set<GamePlatform> platforms = new HashSet<>();
    private final Set<GameGenre> genres = new HashSet<>();

    public Game(UUID id, String title, LocalDate releaseDate, int minimumAge, long priceInCents) {
        this.id = id;
        setTitle(title);
        setReleaseDate(releaseDate);
        setMinimumAge(minimumAge);
        setPriceInCents(priceInCents);
    }

    public Game(String title, LocalDate releaseDate, int minimumAge, long priceInCents) {
        this(null, title, releaseDate, minimumAge, priceInCents);
    }

    public Game(String title, LocalDate releaseDate, long priceInCents) {
        this(null, title, releaseDate, 0, priceInCents);
    }

    public final boolean hasAgeRestriction() {
        return minimumAge > 0;
    }

    public final boolean forbidsAgeOf(int age) {
        return age >= minimumAge;
    }

    public final void removeAgeRestriction() {
        minimumAge = 0;
    }

    public final boolean hasPlatform(GamePlatform platform) {
        Objects.requireNonNull(platform);

        return platforms.contains(platform);
    }

    public final void addPlatform(GamePlatform platform) {
        if (hasPlatform(platform))
            return;

        platforms.add(platform);
    }

    public final void removePlatform(GamePlatform platform) {
        Objects.requireNonNull(platform);

        platforms.remove(platform);
    }

    public final List<GamePlatform> getPlatformsList() {
        return new ArrayList<>(platforms);
    }

    public final boolean hasGenre(GameGenre genre) {
        Objects.requireNonNull(genre);

        return genres.contains(genre);
    }

    public final void addGenre(GameGenre genre) {
        if (hasGenre(genre))
            return;

        genres.add(genre);
    }

    public final void removeGenre(GameGenre genre) {
        Objects.requireNonNull(genre);

        genres.remove(genre);
    }

    public final List<GameGenre> getGenresList() {
        return new ArrayList<>(genres);
    }

    public final UUID getId() {
        return id;
    }

    public final void setId(UUID id) {
        Objects.requireNonNull(id);

        this.id = id;
    }

    public final String getTitle() {
        return title;
    }

    private final void setTitle(String title) {
        Objects.requireNonNull(title);

        if (title.isEmpty())
            throw new IllegalArgumentException("Cannot set an empty string as a title");

        this.title = title;
    }

    public final LocalDate getReleaseDate() {
        return releaseDate;
    }

    public final void setReleaseDate(LocalDate releaseDate) {
        Objects.requireNonNull(releaseDate);

        this.releaseDate = releaseDate;
    }

    public final int getMinimumAge() {
        return minimumAge;
    }

    public final void setMinimumAge(int minimumAge) {
        if (minimumAge < 0)
            throw new IllegalArgumentException("The minimum age must be a non-negative number!");
        this.minimumAge = minimumAge;
    }

    public long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(long priceInCents) {
        if (priceInCents < 0)
            throw new IllegalArgumentException("Price must be a non-negative number!");
        this.priceInCents = priceInCents;
    }
}
