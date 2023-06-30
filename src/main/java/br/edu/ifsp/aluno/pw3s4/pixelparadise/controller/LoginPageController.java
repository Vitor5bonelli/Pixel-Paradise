package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.customer.Customer;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.entities.employee.Employee;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.FindCustomerUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.EmployeeDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.employee.FindEmployeeUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/LoginPage")
public class LoginPageController {

    private final FindCustomerUseCase findCustomerUseCase;
    private final FindEmployeeUseCase findEmployeeUseCase;

    public LoginPageController(FindCustomerUseCase findCustomerUseCase, FindEmployeeUseCase findEmployeeUseCase) {
        this.findCustomerUseCase = findCustomerUseCase;
        this.findEmployeeUseCase = findEmployeeUseCase;
    }


    @GetMapping
    public String loadPage(){
        return  "public/loginPage";
    }

    @GetMapping("css/login.css")
    public String getCss() {
        return "css/login";
    }

    @PostMapping("/loginUser")
    public String login(@RequestParam String username, @RequestParam String password){
        Optional<CustomerDTO> customer = findCustomerUseCase.findOneByNickname(username);
        Optional<EmployeeDTO> employee = findEmployeeUseCase.findOneByNickname(username);

        if (customer.isPresent()){
            return "/Stock";
        }

        if (employee.isPresent()){
            return "/ControleFuncionario";
        }

        return  "/LoginPage";
    }

}
