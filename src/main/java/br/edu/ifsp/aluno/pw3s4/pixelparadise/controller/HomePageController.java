package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.CreateGameUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.FindGameUseCase;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.GameDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomePageController {

    private final FindGameUseCase findGameUseCase;

    public HomePageController(FindGameUseCase findGameUseCase) {
        this.findGameUseCase = findGameUseCase;
    }

    @GetMapping
    public String loadPage(Model model){
        List<GameDTO> listOfGames = findGameUseCase.findAll();

        model.addAttribute("listGames", listOfGames);

        return "public/PaginaHome";
    }

}
