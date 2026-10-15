package videogames.news.com.services;

import videogames.news.com.model.NewsSummary;

import java.util.List;

public interface NewsService {
    List<NewsSummary> allNews();
    NewsSummary newsDetails(String newsTitle);
}
