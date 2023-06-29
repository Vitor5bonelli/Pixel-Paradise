package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/RegisterFunctionary")
public class RegisterFunctionaryPageController {

    @GetMapping
    public String loadPage(){
        return "public/RegisterFunctionary";
    }

    @GetMapping
    public String loadCss(){
        return "css/login";
    }
}