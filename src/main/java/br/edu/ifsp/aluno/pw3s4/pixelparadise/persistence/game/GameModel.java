package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "game", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "releaseDate"}))
public final class GameModel {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @Column(nullable = false)
    private Integer minimumAge;
    @Column(nullable = false)
    private Long priceInCents;
    @ElementCollection
    @CollectionTable(name = "game_platforms", joinColumns = @JoinColumn(name = "id_game"))
    @Column(name = "platform")
    private List<String> platforms;
    @ElementCollection
    @CollectionTable(name = "game_genres", joinColumns = @JoinColumn(name = "id_game"))
    @Column(name = "genres")
    private List<String> genres;

    public GameModel(UUID id, String title, LocalDate releaseDate, Integer minimumAge, Long priceInCents,
                     List<String> platforms, List<String> genres) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.minimumAge = minimumAge;
        this.priceInCents = priceInCents;
        this.platforms = platforms;
        this.genres = genres;
    }

    public GameModel() {
        this(null, null, null, null, null, null, null);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(Integer minimumAge) {
        this.minimumAge = minimumAge;
    }

    public Long getPriceInCents() {
        return priceInCents;
    }

    public void setPriceInCents(Long priceInCents) {
        this.priceInCents = priceInCents;
    }

    public List<String> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<String> platforms) {
        this.platforms = platforms;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
}
