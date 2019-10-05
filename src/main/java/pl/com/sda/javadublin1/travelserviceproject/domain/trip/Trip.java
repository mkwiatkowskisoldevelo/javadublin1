package pl.com.sda.javadublin1.travelserviceproject.domain.trip;

import java.time.LocalDate;
import java.time.Period;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.com.sda.javadublin1.travelserviceproject.domain.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Trip extends BaseEntity {

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;

  //  @ManyToOne
  //  private City cityFrom;
  //
  //  @ManyToOne
  //  private Airport airportFrom;

  // adnotacje @Embedded uzywamy na klasie ktora ma adnotacje @Embeddable
  // sprawi to, ze pola z klasy From zostane dodane do tabeli "trip"
  // w ten sposob mamy 3 klasy Java a 1 tabele sql
  @Embedded
  private From from;

  //  @ManyToOne
  //  private City cityTo;
  //
  //  @ManyToOne
  //  private Hotel hotel;
  //
  //  @ManyToOne
  //  private Airport airportTo;

  @Embedded
  private To to;

  // ta adnotacja sprawia, ze wartosci z enuma w bazie danych beda zapisane jako string
  // a nie wartosc numeryczna (domyslne zachowanie)
  @Enumerated(value = EnumType.STRING)
  private Catering catering;

  private LocalDate departureDate;
  private LocalDate returnDate;
  private Double adultPrice;
  private Double kidsPrice;
  private boolean promoted;
  private Integer adultPlacesAvailable;
  private Integer childPlacesAvailable;

  public int getDuration() {
    return Period.between(departureDate, returnDate).getDays();
  }
}
