package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/PurchaseGames")

public class PurchaseGamesController {
    @GetMapping
    public String carregaPagina() {return "public/PurchaseGames";}

    @GetMapping("css/estilo geral.css")
    public String getCss() {
        return "css/estilo geral.css";
    }
}
