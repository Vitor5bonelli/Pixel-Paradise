package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.CreateGameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.CreateGameUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ControleFuncionario")
public class FunctionaryPageController {

    private final  CreateGameUseCase createGameUseCase;

    public FunctionaryPageController(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    @GetMapping
    public String loadPage(){
        return "public/FunctionaryPage";
    }

    @PostMapping
    public String createGame(CreateGameDTO gameDTO){
        createGameUseCase.createGame(gameDTO);



        return "public/FunctionaryPage";
    }
}
