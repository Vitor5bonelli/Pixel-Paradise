package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/WishList")
public class WishListPageController {

    @GetMapping
    public String loadPage(){
        return "public/WishList";
    }

    @GetMapping("css/estilo geral.css")
    public String loadCss(){
        return "css/estilo geral";
    }
}
