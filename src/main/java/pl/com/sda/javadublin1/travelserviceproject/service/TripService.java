package pl.com.sda.javadublin1.travelserviceproject.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.sda.javadublin1.travelserviceproject.domain.trip.Trip;
import pl.com.sda.javadublin1.travelserviceproject.exception.ValidationDataException;
import pl.com.sda.javadublin1.travelserviceproject.repository.TripRepository;

// do service'u wrzucamy wszystko
@Service
public class TripService {

  @Autowired
  private TripRepository tripRepository;

  public Trip validateAndSave(Trip trip) {
    if (trip.getReturnDate()
        .isBefore(trip.getDepartureDate())) {
      throw new ValidationDataException(
          "return date before departure date");
    }
    return tripRepository.save(trip);
  }

  public void delete(Long id) {
    if (!tripRepository.existsById(id)) {
      // TODO: throw not found exception
    }
    tripRepository.deleteById(id);
  }

  public Trip getById(Long id) {
    Optional<Trip> trip = tripRepository.findById(id);

    if (!trip.isPresent()) {
      // obsluga jesli trip o podanym id nie istnieje w bazie
      // TODO: throw not found exception
    }

    return trip.get();
  }

  public Trip update(Trip trip, Long id) {
    // TODO: remove code duplication, DRY!!!!
    if (!tripRepository.existsById(id)) {
      // TODO: throw not found exception
    }
    // musimy podstawic id bo mozemy wyslac inne id w body i inne w URL
    trip.setId(id);
    return tripRepository.save(trip);
  }
}
