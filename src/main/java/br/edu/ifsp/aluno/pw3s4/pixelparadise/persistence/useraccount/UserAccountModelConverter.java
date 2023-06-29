package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account.RequestUserAccountDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.game.GameModel;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public final class UserAccountModelConverter {
    public static UserAccountModel fromDTO(RequestUserAccountDTO userAccountDTO) {
        if (userAccountDTO == null)
            return null;
        Set<String> permissionsSet = Arrays.stream(userAccountDTO.permissions()).collect(Collectors.toSet());

        return new UserAccountModel(userAccountDTO.id(), userAccountDTO.username(), userAccountDTO.email(),
                        userAccountDTO.password(), permissionsSet);
    }

    public static RequestUserAccountDTO toDTO(UserAccountModel userAccountModel) {
        if (userAccountModel == null)
            return null;

        String[] permissions = (String[])userAccountModel.getPermissions()
                                    .stream()
                                    .filter(Objects::nonNull)
                                    .toArray();

        return new RequestUserAccountDTO(userAccountModel.getId(), userAccountModel.getUsername(), userAccountModel.getEmail(),
                userAccountModel.getPassword(), permissions);
    }
}