package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.customer.CustomerDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/RegisterCustomer")
public class RegisterCustomerPageController {

    @GetMapping
    public String loadPage(){
        return  "public/RegisterClient";
    }

    @GetMapping("css/login.css")
    public String getCss() {
        return "css/login";
    }

    @PostMapping("registerClient")
    public String registerCustomer(CustomerDTO customerData){

        /*
        Customer customer =
        cadastro = validarCadastro(dadosCliente);

        if(cadastro==true): return "public/Login";

        exibirErro();
        return  "public/Register";
         */
        return  "public/Login";
    }
}
