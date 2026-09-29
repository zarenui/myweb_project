package videogames.news.com.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import videogames.news.com.model.VideogamesSummary;
import videogames.news.com.services.VideogamesService;

import java.util.stream.Collectors;

public class VideogamesController {

    private final VideogamesService videogamesService;

    public VideogamesController(VideogamesService videogamesService){
        this.videogamesService = videogamesService;
    }

    @GetMapping(value = "/", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String home(){
        return "Новостной сайт про видеоигры.";
    }

    @GetMapping(value = "/videogames", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String videogames(){
        return videogamesService.allVideogames().stream()
                .map(this::formatVideogames)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatVideogames(VideogamesSummary videogames){
        return videogames.title() + " | " + videogames.genre();
    }

    @GetMapping(value = "/news", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String news(){
        return "Пока пусто";
    }


//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public String message(){
//        return "Ой, тут еще ничего нету. Но скоро появится";
//    }
}
