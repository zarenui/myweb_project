package videogames.news.com.services.exceptions;

public class VideogameNotFoundException extends RuntimeException {

    public VideogameNotFoundException(String videoGame) {
        super("Игра с названием '" + videoGame + "' не найдена");
    }
}
