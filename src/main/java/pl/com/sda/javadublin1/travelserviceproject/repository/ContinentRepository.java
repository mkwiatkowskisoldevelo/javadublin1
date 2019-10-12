package pl.com.sda.javadublin1.travelserviceproject.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.core.config.Projection;
import pl.com.sda.javadublin1.travelserviceproject.domain.Continent;

@RepositoryRestResource(path = "continents")
public interface ContinentRepository extends JpaRepository<Continent, Long> {

  @Override
  @RestResource(exported = false)
  void deleteById(Long id);

  List<Continent> findByNameContaining(@Param("name") String name);
//  Page<Continent> findByNameContaining(@Param("name") String name, Pageable pageable);
}

