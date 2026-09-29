package videogames.news.com.catalog;

import videogames.news.com.model.VideogamesSummary;

import java.util.List;

public interface VideogamesCatalog {
    List<VideogamesSummary> findAll();
}
