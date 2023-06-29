package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.RequestUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;

public final class UserAccountModelConverter {
    public static UserAccountModel fromDTO(RequestUserAccountDTO userAccountDTO) {
        if (userAccountDTO == null)
            return null;
        return new UserAccountModel(userAccountDTO.id(), userAccountDTO.username(), userAccountDTO.email(), userAccountDTO.password());
    }

    public static RequestUserAccountDTO toDTO(UserAccountModel userAccountModel) {
        if (userAccountModel == null)
            return null;
        return new RequestUserAccountDTO(userAccountModel.getId(), userAccountModel.getUsername(), userAccountModel.getEmail(),
                userAccountModel.getPasswordAsString());
    }
}