package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class From {

  @ManyToOne
  private City cityFrom;

  @ManyToOne
  private Airport airportFrom;
}
