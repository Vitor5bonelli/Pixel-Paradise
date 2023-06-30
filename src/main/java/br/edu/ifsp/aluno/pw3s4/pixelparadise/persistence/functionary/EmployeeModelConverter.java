package br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.functionary;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.persistence.useraccount.UserAccountModel;

public final class EmployeeModelConverter {
    public static EmployeeModel fromDTO(EmployeeDTO employeeDTO){
        if (employeeDTO == null)
            return null;
        return new EmployeeModel(employeeDTO.id(), employeeDTO.preferredName(), employeeDTO.cpf(), employeeDTO.phoneNumber(), employeeDTO.wageInCents());
    }

    public static EmployeeDAO toDTO(EmployeeModel employeeModel){return null;}
}
