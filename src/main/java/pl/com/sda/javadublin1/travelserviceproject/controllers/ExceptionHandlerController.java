package pl.com.sda.javadublin1.travelserviceproject.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.com.sda.javadublin1.travelserviceproject.exception.NotFoundException;
import pl.com.sda.javadublin1.travelserviceproject.exception.ValidationDataException;

// klasa ta sluzy do obslugi wyjatkow
// poznizsza adnotacja jest wymagana, zeby obsluga ta dzialala
@RestControllerAdvice
public class ExceptionHandlerController {


  // nizej w adnotacji @ExceptionHandler podajemy klase wyjatku do obslugi
  @ExceptionHandler(ValidationDataException.class)
  // jesli wyjate wystapi to zwrocimy kod HTTP podany w adnotacji @ResponseStatus
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorMessage handleValidationException(ValidationDataException exception) {
    return new ErrorMessage(exception.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorMessage handleNotFoundException(NotFoundException exception) {
    return new ErrorMessage(exception.getMessage());
  }

  @Data
  @AllArgsConstructor
  private class ErrorMessage {
    private String message;
  }
}
