package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @GetMapping
    public String carregaPagina(){
        return  "public/Register";
    }

    @GetMapping("css/login.css")
    public String getCss() {
        return "css/login";
    }

    @PostMapping
    public String realizarCadastro(){
        System.out.println("Realizou Cadastro");
        return  "public/Register";
    }
}
