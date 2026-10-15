package videogames.news.com.services.exceptions;

public class NewsNotFoundException extends RuntimeException {
    public NewsNotFoundException(String newsTitle) {
        super("Новость с названием '" + newsTitle + "' не найдена");
    }
}
