package videogames.news.com.catalog;

import videogames.news.com.model.VideogamesSummary;

import java.util.Collections;
import java.util.List;

public class InMemoryVideogamesCatalog implements VideogamesCatalog{

    private final List<VideogamesSummary> videogames = List.of(
            new VideogamesSummary("Dota 2", "MOBA"),
            new VideogamesSummary("Counter Strike 2", "Shooter"),
            new VideogamesSummary("Deadlock", "MOBA + 3-rd person shooter"),
            new VideogamesSummary("World of Warcraft", "MMORPG")
    );
    @Override
    public List<VideogamesSummary> findAll(){
        return Collections.unmodifiableList(videogames);
    }
}
