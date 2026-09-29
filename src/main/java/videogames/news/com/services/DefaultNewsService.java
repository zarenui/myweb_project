package videogames.news.com.services;

import org.springframework.stereotype.Service;
import videogames.news.com.catalog.NewsCatalog;
import videogames.news.com.model.NewsSummary;

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
}
