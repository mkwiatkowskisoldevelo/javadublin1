package pl.com.sda.javadublin1.travelserviceproject.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

// encja podstawowa, po ktorej wszystkie encje dziedzicza
// zostala stworzona, zeby nie kopiowac pola id w kazdej encji
// aby w tabeli pojawilo sie pole id zdefinowane nizej
// potrzebna jest adnotacja @MappedSuperclass,
// bez tego np. w encji City id nie bedzie
@MappedSuperclass
@Data
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;
}
