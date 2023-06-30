package br.edu.ifsp.aluno.pw3s4.pixelparadise.controller;

import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.CreateGameDTO;
import br.edu.ifsp.aluno.pw3s4.pixelparadise.domain.usecases.game.CreateGameUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ControleFuncionario")
public class FunctionaryPageController {

    private final  CreateGameUseCase createGameUseCase;

    public FunctionaryPageController(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    @GetMapping
    public String loadPage(){
        return "public/FunctionaryPage.html";
    }

    @GetMapping("css/style functionary.css")
    public String getCss(){
        return "public/FunctionaryPage";
    }

    @PostMapping
    public String createGame(CreateGameDTO gameDTO, @RequestParam("platforms[]") List<String> platforms, @RequestParam("genres[]") List<String> genres){
        CreateGameDTO updatedGameDTO = new CreateGameDTO(
                gameDTO.title(),
                gameDTO.releaseDate(),
                gameDTO.minimumAge(),
                gameDTO.priceInCents(),
                platforms,
                genres
        );

        createGameUseCase.createGame(updatedGameDTO);

        System.out.println("Função Executada");

        return "public/FunctionaryPage";
    }
}
