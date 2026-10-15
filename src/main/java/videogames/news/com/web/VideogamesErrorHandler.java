package videogames.news.com.web;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import videogames.news.com.services.exceptions.VideogameNotFoundException;

@ControllerAdvice
public class VideogamesErrorHandler {

    @ExceptionHandler(VideogameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String companyNotFound(VideogameNotFoundException exception, Model model) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "error/videogame-not-found";
    }
}
