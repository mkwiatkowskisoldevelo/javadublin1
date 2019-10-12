package pl.com.sda.javadublin1.travelserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import pl.com.sda.javadublin1.travelserviceproject.domain.City;
import pl.com.sda.javadublin1.travelserviceproject.domain.Hotel;

@RepositoryRestResource(path = "hotels", excerptProjection = HotelProjection.class)
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}

@Projection(types = { Hotel.class })
interface HotelProjection {
  String getId();
  String getName();
  City getCity();
  Integer getStars();
  String getDescription();
}