package pl.com.sda.javadublin1.travelserviceproject.controllers;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.com.sda.javadublin1.travelserviceproject.domain.trip.Trip;
import pl.com.sda.javadublin1.travelserviceproject.service.TripService;

// do controllera wrzucamy wylacznie rzeczy odpowiedzialne za obsluge zapytan http
// uzywamy @RestController kiedy nie uzywamy template engine i piszemy REST-owy controller
@RestController
// wszystkie ponizsze metody beda mialy URL zaczynajacy sie od "/trips"
// na koncu i poczatku definicji sciezki URL nie musimy dawac "/", spring sam nam je doda
@RequestMapping("trips")
// umozliwia polaczenie sie frontendu z nasza aplikacja
@CrossOrigin
public class TripController {

  // jesli chcemy skorzystac z komponentu springowego (controller, service, repository)
  // jak poniezej, musimy uzyc adnotacji @Autowired
  @Autowired
  private TripService tripService;

  // RESTowy controller powinien miec ponizsze metody CRUD
  // 1. GET    "/trips"      - do pobierania wszystkich i szukania po parametrach
  // 2. GET    "/trips/{id}" - do pobierania pojedynczego elementu
  // 3. POST   "/trips"      - do tworzenia nowego elementu
  // 4. DELETE "/trips/{id}" - do usuwania elementu po id
  // 5. PUT    "/trips/{id}" - do aktualizowania elementu po id

  // @RequestMapping(method = RequestMethod.GET, name = "/trips") <- roznowazne poznizszemy zapisowi
  @GetMapping
  public List<Trip> getAll() {
    return tripService.getAll();
  }

  @GetMapping("paginated")
  public Page<Trip> getAll(Pageable pageable) {
    System.out.println(pageable.getPageSize());
    System.out.println(pageable.getPageNumber());
    System.out.println(pageable.getSort());
    return tripService.getAll(pageable);
  }

  @PostMapping
  // @ResponseStatus sluzy do zdefiniowania kodu odpowiedzi HTTP (w tym wypadku 201) jesli ponizsza metoda nie rzuci wyjatku
  @ResponseStatus(HttpStatus.CREATED)
  public Trip create(@RequestBody Trip trip) {
     return tripService.validateAndSave(trip);
  }

  // {id} -> pomiedzy {} dajemy nazwe parametru (powinna pozniej odpowiadac nazwie parametru funkcji)
  // i nastepnie wartosc, ktora wpiszemy w URL w to miejsce trafi to tego parametru przy wywolaniu ponizszej funkcji,
  // np. DELETE "/trips/10" - wywola ponizsza metode delete z parametrem o wartosci 10
  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    tripService.delete(id);
  }

  @GetMapping("{id}")
  public Trip getById(@PathVariable Long id) {
    return tripService.getById(id);
  }

  @PutMapping("{id}")
  public Trip update(@RequestBody Trip trip, @PathVariable Long id) {
    return tripService.update(trip, id);
  }
}
