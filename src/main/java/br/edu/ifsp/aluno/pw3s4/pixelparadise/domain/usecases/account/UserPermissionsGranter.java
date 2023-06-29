package br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.account;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.account.UserPermission;

import java.util.HashSet;
import java.util.Set;

public class UserPermissionsGranter {
    public Set<UserPermission> getCustomerPermissionSet() {
        return Set.of(UserPermission.LOGIN, UserPermission.PURCHASE_GAME, UserPermission.RETRIEVE_ANY_GAME,
                        UserPermission.RETRIEVE_PURCHASED_GAMES);
    }

    public Set<UserPermission> getEmployeePermissionSet() {
        return Set.of(UserPermission.LOGIN, UserPermission.CREATE_GAME, UserPermission.RETRIEVE_ANY_GAME,
                        UserPermission.UPDATE_GAME, UserPermission.DELETE_GAME);
    }

    public Set<UserPermission> getAdminPermissionSet() {
        Set<UserPermission> adminPermissions = new HashSet<>(getEmployeePermissionSet());
        adminPermissions.add(UserPermission.CREATE_EMPLOYEE);
        adminPermissions.add(UserPermission.RETRIEVE_EMPLOYEE);
        adminPermissions.add(UserPermission.UPDATE_EMPLOYEE);
        adminPermissions.add(UserPermission.DELETE_EMPLOYEE);

        return adminPermissions;
    }
}
