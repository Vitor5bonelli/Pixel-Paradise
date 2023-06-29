package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Stock")

public class StockController {
    @GetMapping
    public String carregaPagina(){return "public/Stock";}

    @GetMapping
    public String getCss(){return  "css/estilo geral.css";}
}
