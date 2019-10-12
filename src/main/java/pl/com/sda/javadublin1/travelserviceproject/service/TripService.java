package pl.com.sda.javadublin1.travelserviceproject.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.com.sda.javadublin1.travelserviceproject.domain.trip.Trip;
import pl.com.sda.javadublin1.travelserviceproject.exception.NotFoundException;
import pl.com.sda.javadublin1.travelserviceproject.exception.ValidationDataException;
import pl.com.sda.javadublin1.travelserviceproject.repository.TripRepository;

// do service'u wrzucamy cala logike, czyli np. walidacje
@Service
public class TripService {

  private static final String TRIP_NOT_FOUND = "Trip with id %s not found.";

  @Autowired
  private TripRepository tripRepository;

  public Trip validateAndSave(Trip trip) {
    if (trip.getReturnDate()
        .isBefore(trip.getDepartureDate())) {
      String message = String.format(
          "Return date (%s) is before departure date (%s)",
          trip.getReturnDate(),
          trip.getDepartureDate());
      throw new ValidationDataException(message);
    }
    return tripRepository.save(trip);
  }

  public void delete(Long id) {
    if (!tripRepository.existsById(id)) {
      throw new NotFoundException(
          String.format(TRIP_NOT_FOUND, id));
    }
    tripRepository.deleteById(id);
  }

  public Trip getById(Long id) {
    Optional<Trip> trip = tripRepository.findById(id);

    if (!trip.isPresent()) {
      // obsluga jesli trip o podanym id nie istnieje w bazie
      throw new NotFoundException(
          String.format(TRIP_NOT_FOUND, id));
    }

    return trip.get();
  }

  public Trip update(Trip trip, Long id) {
    // TODO: remove code duplication, DRY!!!!
    if (!tripRepository.existsById(id)) {
      throw new NotFoundException(
          String.format(TRIP_NOT_FOUND, id));
    }
    // musimy podstawic id bo mozemy wyslac inne id w body i inne w URL
    trip.setId(id);
    return tripRepository.save(trip);
  }

  public List<Trip> getAll() {
    return tripRepository.findAll();
  }

  public Page<Trip> getAll(Pageable pageable) {
    return tripRepository.findAll(pageable);
  }
}
