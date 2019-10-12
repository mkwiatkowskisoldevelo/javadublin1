package pl.com.sda.javadublin1.travelserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import pl.com.sda.javadublin1.travelserviceproject.domain.Airport;
import pl.com.sda.javadublin1.travelserviceproject.domain.City;

@RepositoryRestResource(path = "airports")
public interface AirportRepository extends JpaRepository<Airport, Long> {

}

@Projection(types = { Airport.class })
interface AirportProjection {
  String getId();
  String getName();
  City getCity();
}