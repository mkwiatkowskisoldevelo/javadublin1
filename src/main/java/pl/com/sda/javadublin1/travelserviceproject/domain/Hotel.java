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
public class Hotel extends BaseNameEntity {

  //  @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //  private Long id;
  //
  //  private String name;

  private Integer stars;

  private String description;

  @ManyToOne
  private City city;
}
