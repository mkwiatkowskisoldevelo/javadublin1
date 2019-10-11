package pl.com.sda.javadublin1.travelserviceproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.com.sda.javadublin1.travelserviceproject.domain.trip.Trip;

// Mamy 4 typy repositories do wyboru, kazdy nastepny rozszeza poprzeni
// 1. Repository                 - nie zawiera zadnych metod
// 2. CrudRepository             - zawiera podstawowe metody do CRUD'a (save, saveAll, findAll, findById, deleteById...)
// 3. PagingAndSortingRepository - do poprzednich metod dorzuca ich warianty wspierajace sortowanie i paginacje
// 4. JpaRepository              - ma dodatkowe metody specjalne, np. saveAndFlush, czasem przydaja sie w szczegolnych przypadkach
public interface TripRepository extends JpaRepository<Trip, Long> {
}
