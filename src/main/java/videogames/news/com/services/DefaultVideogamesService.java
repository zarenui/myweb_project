package videogames.news.com.services;

import org.springframework.stereotype.Service;
import videogames.news.com.catalog.NewsCatalog;
import videogames.news.com.catalog.VideogamesCatalog;
import videogames.news.com.model.VideogamesSummary;
import videogames.news.com.services.exceptions.VideogameNotFoundException;

import java.util.List;

@Service
public class DefaultVideogamesService implements VideogamesService {

    private final VideogamesCatalog videogamesCatalog;

    public DefaultVideogamesService(VideogamesCatalog videogamesCatalog){
        this.videogamesCatalog = videogamesCatalog;
    }

    @Override
    public List<VideogamesSummary> allVideogames() {
        return videogamesCatalog.findAll();
    }

    @Override
    public VideogamesSummary gameDetails(String videogameTitle) {
        return videogamesCatalog.findAll().stream()
                .filter(videogame -> videogame.title().equals(videogameTitle))
                .findFirst()
                .orElseThrow(() -> new VideogameNotFoundException(videogameTitle));
    }
}
