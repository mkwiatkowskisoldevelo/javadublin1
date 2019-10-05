package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "continents")
public class Continent extends BaseNameEntity {

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;

  //  private String name;


  public Continent(Long id, String name) {
    this.id = id;
    this.name = name;
  }
}
