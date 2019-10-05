package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class BaseNameEntity extends BaseEntity {
  protected String name;
}
