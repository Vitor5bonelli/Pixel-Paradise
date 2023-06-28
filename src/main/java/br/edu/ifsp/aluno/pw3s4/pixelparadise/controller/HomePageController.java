package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    @GetMapping
    public String loadPage(){
        return "public/PaginaHome";
    }

    public String exhibitGames(){
        return "public/PaginaHome";
    }
}
