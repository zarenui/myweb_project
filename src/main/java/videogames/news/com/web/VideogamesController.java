package videogames.news.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import videogames.news.com.services.VideogamesService;

@Controller
@RequestMapping("/games")
public class VideogamesController {

    private final VideogamesService videogamesService;

    public VideogamesController(VideogamesService videogamesService) {
        this.videogamesService = videogamesService;
    }

    @GetMapping
    public String allGames(Model model) {
        model.addAttribute("videogameInfos", videogamesService.allVideogames());
        return "games-all";
    }

    @GetMapping("/{videogameTitle}")
    public String companyDetails(
            @PathVariable String videogameTitle,
            Model model
    ) {
        model.addAttribute(
                "videogameDetails",
                videogamesService.gameDetails(videogameTitle)
        );
        return "videogame-details";
    }
}
