package pl.com.sda.javadublin1.travelserviceproject.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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

  @Embedded
  private From from;
//
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
