package videogames.news.com.web;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import videogames.news.com.model.NewsSummary;
import videogames.news.com.model.VideogamesSummary;
import videogames.news.com.services.NewsService;
import videogames.news.com.services.VideogamesService;

import java.util.stream.Collectors;

@Controller
public class VideogamesController {

    private final VideogamesService videogamesService;
    private final NewsService newsService;

    public VideogamesController(VideogamesService videogamesService, NewsService newsService){
        this.videogamesService = videogamesService;
        this.newsService = newsService;
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
        return newsService.allNews().stream()
                .map(this::formatNews)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String formatNews(NewsSummary news){
        return news.title() + " | " + news.text();
    }

    @GetMapping(value = "/**", produces = "text/plain;charset=UTF-8")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String message(){
        return "Ой, тут еще ничего нету. Но скоро появится (возможно но не точно)";
    }
}
