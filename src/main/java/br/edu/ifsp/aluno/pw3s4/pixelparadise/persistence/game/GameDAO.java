package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GameDAO extends JpaRepository<GameModel, UUID> {
}
