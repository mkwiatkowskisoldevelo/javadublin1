package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.Entity;
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
public class Country extends BaseNameEntity {

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;
  //
  //  private String name;

  // adnotacja ta laczy tabele pomiedzy encjami
  // @ManyToOne uzywamy nad polami, ktore nie sa kolekcjami
  // @OneToMany uzywamy nad polami ktore sa kolekcjami
  // @OneToOne uzywamy nad polami, ktore sa wydzielona czescia danej klasy
  // np. dane kontaktowe uzyytkownika
  @ManyToOne
  private Continent continent;
}
