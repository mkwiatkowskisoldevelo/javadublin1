package pl.com.sda.javadublin1.travelserviceproject.exception;

// mozemy zdefiniowac wlasne wyjatki dla springa
// bedziemy tworzyc inny wyjatek dla kazdego blednego kodu HTTP (> 400, < 500)
// ten bedzie odpowiadal za kod 400 - Bad Request
public class ValidationDataException extends RuntimeException {

  public ValidationDataException(String message) {
    super(message);
  }

//  public ValidationDataException(String message) {
//    this.message = message;
//  }
}
