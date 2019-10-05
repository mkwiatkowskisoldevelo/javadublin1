package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import lombok.Data;

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
