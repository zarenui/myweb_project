package videogames.news.com.services;

import videogames.news.com.model.VideogamesSummary;

import java.util.List;

public interface VideogamesService {
    List<VideogamesSummary> allVideogames();
    VideogamesSummary gameDetails(String videogameTitle);
}
