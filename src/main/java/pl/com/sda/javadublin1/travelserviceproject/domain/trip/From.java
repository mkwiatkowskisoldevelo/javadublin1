package pl.com.sda.javadublin1.travelserviceproject.domain.trip;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import lombok.Data;
import pl.com.sda.javadublin1.travelserviceproject.domain.Airport;
import pl.com.sda.javadublin1.travelserviceproject.domain.City;

// jesli uzyjemy @Embeddable zamiast @Entity
// to pola z ponizszej klasy zostana dodane do tabeli wykorzystujacej ta klase
// a nie do nowej tabeli, w tym wypadku nie bedzie tabeli "from"
@Embeddable
@Data
public class From {

  @ManyToOne
  private City cityFrom;

  @ManyToOne
  private Airport airportFrom;
}
