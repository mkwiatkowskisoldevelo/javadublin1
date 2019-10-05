package pl.com.sda.javadublin1.travelserviceproject.domain.trip;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import lombok.Data;
import pl.com.sda.javadublin1.travelserviceproject.domain.Airport;
import pl.com.sda.javadublin1.travelserviceproject.domain.City;
import pl.com.sda.javadublin1.travelserviceproject.domain.Hotel;

@Embeddable
@Data
public class To {

  @ManyToOne
  private City cityTo;

  @ManyToOne
  private Hotel hotel;

  @ManyToOne
  private Airport airportTo;
}
