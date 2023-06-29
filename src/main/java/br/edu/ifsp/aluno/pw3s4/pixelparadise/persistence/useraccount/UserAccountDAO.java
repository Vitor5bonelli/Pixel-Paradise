package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserAccount;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserAccountDAO extends JpaRepository<UserAccountModel, UUID> {
}
