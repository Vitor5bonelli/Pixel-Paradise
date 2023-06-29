package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/LoginPage")
public class LoginPageController {

    @GetMapping
    public String carregaPagina(){
        return  "public/loginPage";
    }

    @GetMapping("css/login.css")
    public String getCss() {
        return "css/login";
    }

    @PostMapping
    public String realizarCadastro(){
        System.out.println("Realizou Login");
        return  "public/loginPage";
    }

}
