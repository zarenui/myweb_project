package videogames.news.com.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import videogames.news.com.services.exceptions.NewsNotFoundException;

@ControllerAdvice
public class NewsErrorHandler {

    @ExceptionHandler(NewsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String companyNotFound(NewsNotFoundException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error/news-not-found";
    }
}
