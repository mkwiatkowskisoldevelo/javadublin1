package pl.com.sda.javadublin1.travelserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;
import pl.com.sda.javadublin1.travelserviceproject.domain.Continent;
import pl.com.sda.javadublin1.travelserviceproject.domain.Country;

// uzywajac @RepositoryRestResource tworzymy motedy restowe bez koniecznosci pisania wlasnego controller'a
// path uzywamy zeby zdefiniowac sciezke do zasobu (w controllerze uzywalismy @RequestMapping nad klasa)
@RepositoryRestResource(path = "countries", excerptProjection = CountryProjection.class)
public interface CountryRepository extends JpaRepository<Country, Long> {

}

// sluzy do tego, aby pole continent pojawilo sie w odpowiedzi servera
@Projection(types = { Country.class })
interface CountryProjection {
  String getId();
  String getName();
  Continent getContinent();
}