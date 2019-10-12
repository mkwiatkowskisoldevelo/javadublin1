package pl.com.sda.javadublin1.travelserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import pl.com.sda.javadublin1.travelserviceproject.domain.City;
import pl.com.sda.javadublin1.travelserviceproject.domain.Country;

@RepositoryRestResource(path = "cities", excerptProjection = CityProjection.class)
public interface CityRepository extends JpaRepository<City, Long> {

}

@Projection(name = "cityProjection", types = { City.class })
interface CityProjection {
  String getId();
  String getName();
  Country getCountry();
}