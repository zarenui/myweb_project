package videogames.news.com.catalog;

import org.springframework.stereotype.Repository;
import videogames.news.com.model.NewsSummary;
import videogames.news.com.model.VideogamesSummary;

import java.util.List;

@Repository
public class InMemoryNewsCatalog implements NewsCatalog{

    private final List<NewsSummary> news = List.of(
            new NewsSummary("Deadlock", "Вышло новое обновление 0.22", "бла бла бла какие то изменения"),
            new NewsSummary("League of Legends", "Обзор обновления 26.19", "бла бла бла какие то изменения"),
            new NewsSummary("Counter Strike 2", "Вышло обновление с курицами и яицами", "бла бла бла какие то изменения"),
            new NewsSummary("Dota 2", "Обзор обновления 7.41f", "бла бла бла какие то изменения")
    );

    @Override
    public List<NewsSummary> findAll() {
        return news;
    }
}
