package pl.com.sda.javadublin1.travelserviceproject.config;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import pl.com.sda.javadublin1.travelserviceproject.domain.Continent;

@Configuration
public class RestConfiguration implements RepositoryRestConfigurer {

  @Autowired
  private EntityManager entityManager;

  // poznizsza metoda sprawia, ze w odpowiedzi server bedzie zwracal pole id
  // dla wszystkich encji, domysle w data REST to pole jest schowane
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        config.exposeIdsFor(Continent.class);
//    config.exposeIdsFor(Continent.class, Country.class, City.class...);
    config.exposeIdsFor(
        entityManager.getMetamodel().getEntities().stream()
            .map(Type::getJavaType)
            .toArray(Class[]::new));

//    List<Continent> continents = new ArrayList<>();
//    continents.stream()
//        .peek(continent -> continent.toString()); <- zwykla lambda
//        .peek(Continent::toString); <- method reference
  }
}
