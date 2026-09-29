package videogames.news.com.services;

import videogames.news.com.catalog.VideogamesCatalog;
import videogames.news.com.model.VideogamesSummary;

import java.util.List;

public class DefaultVideogamesService implements VideogamesService{

    private final VideogamesCatalog videogamesCatalog;

    public DefaultVideogamesService(VideogamesCatalog videogamesCatalog){
        this.videogamesCatalog = videogamesCatalog;
    }

    @Override
    public List<VideogamesSummary> allVideogames() {
        return videogamesCatalog.findAll();
    }
}
