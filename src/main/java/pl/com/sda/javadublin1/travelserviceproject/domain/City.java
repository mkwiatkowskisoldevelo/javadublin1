package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// jesli uzywamy w klasie extends i nie dodamy @EqualsAndHashCode(callSuper = true)
// to metody equals i hashCode nie beda braly pod uwage pol z klasy rozszerzanej
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class City extends BaseNameEntity {

  // nie potrzebujemy tych 2 pol bo sa zawarte w klasie BaseNameEntity
  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;
  //
  //  private String name;

  @ManyToOne
  private Country country;
}
