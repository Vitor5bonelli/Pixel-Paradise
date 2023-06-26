package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game;

import java.util.UUID;

public record GameKeyDTO(UUID gameId, UUID customerId, long priceInCents) {
}
