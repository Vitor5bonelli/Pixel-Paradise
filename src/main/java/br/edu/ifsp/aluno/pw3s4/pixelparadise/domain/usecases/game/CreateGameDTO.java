package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import java.time.LocalDate;
import java.util.List;

public record CreateGameDTO(String title, LocalDate releaseDate, int minimumAge, long priceInCents,
                            List<String> platforms, List<String> genres) {
}
