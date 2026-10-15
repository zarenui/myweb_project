package videogames.news.com.services;

import org.springframework.stereotype.Service;
import videogames.news.com.catalog.NewsCatalog;
import videogames.news.com.model.NewsSummary;
import videogames.news.com.model.VideogamesSummary;
import videogames.news.com.services.exceptions.NewsNotFoundException;
import videogames.news.com.services.exceptions.VideogameNotFoundException;

import java.util.List;

@Service
public class DefaultNewsService implements NewsService{
    private final NewsCatalog newsCatalog;

    public DefaultNewsService(NewsCatalog newsCatalog){
        this.newsCatalog = newsCatalog;
    }

    @Override
    public List<NewsSummary> allNews() {
        return newsCatalog.findAll();
    }

    @Override
    public NewsSummary newsDetails (String newsTitle) {
        return newsCatalog.findAll().stream()
                .filter(news -> news.title().equals(newsTitle))
                .findFirst()
                .orElseThrow(() -> new NewsNotFoundException(newsTitle));
    }
}
