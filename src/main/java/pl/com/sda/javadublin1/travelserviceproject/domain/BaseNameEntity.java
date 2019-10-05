package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

// klasa z polem name, pomocnicza zeby nie kopiowac pola name kilka razy
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class BaseNameEntity extends BaseEntity {
  protected String name;
}
