package videogames.news.com.catalog;

import videogames.news.com.model.NewsSummary;

import java.util.List;

public interface NewsCatalog {
    List<NewsSummary> findAll();
}
