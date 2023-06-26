package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import java.time.LocalDate;
import java.util.UUID;

public record GameDTO(UUID id, String title, LocalDate releaseDate, int minimumAge, long priceInCents,
                        String[] platforms, String[] genres) {
}
