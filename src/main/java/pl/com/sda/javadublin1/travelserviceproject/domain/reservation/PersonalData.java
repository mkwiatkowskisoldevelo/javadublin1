package pl.com.sda.javadublin1.travelserviceproject.domain.reservation;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.com.sda.javadublin1.travelserviceproject.domain.BaseNameEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonalData extends BaseNameEntity {
  private String surname;
  private Boolean isAdult;
}
