package videogames.news.com.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import videogames.news.com.services.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public String allnews(Model model) {
        model.addAttribute("newsInfos", newsService.allNews());
        return "news-all";
    }

    @GetMapping("/{newsTitle}")
    public String newsDetails(
            @PathVariable String newsTitle,
            Model model
    ) {
        model.addAttribute(
                "newsDetails",
                newsService.newsDetails(newsTitle)
        );
        return "news-details";
    }
}
