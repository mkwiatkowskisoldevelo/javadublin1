package pl.com.sda.javadublin1.travelserviceproject.domain.reservation;

import static java.util.stream.Collectors.toList;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.com.sda.javadublin1.travelserviceproject.domain.BaseEntity;
import pl.com.sda.javadublin1.travelserviceproject.domain.trip.Trip;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reservation extends BaseEntity {

  @ManyToOne
  private Trip trip;

  @OneToMany
  private List<PersonalData> members;

//  private Double price;

  public double getPrice() {
//    double price = 0;
//
//    for (PersonalData member : members) {
//      if (member.getIsAdult()) {
//        price += trip.getAdultsPrice();
//      } else {
//        price += trip.getKidsPrice();
//      }
//    }
//
//    return price;

    return members.stream()
        .mapToDouble(member ->
              member.getIsAdult() ?
              trip.getAdultsPrice() : trip.getKidsPrice())
//        .map(price -> price * 0.95)
        .sum();
  }

  public List<PersonalData> getTripMembers(List<Reservation> reservations) {
//    List<PersonalData> list = new ArrayList<>();
//    for (Reservation reservation : reservations) {
//      for (PersonalData member : reservation.getMembers()) {
//        list.add(member);
//      }
//    }
//
//    return list;

    return reservations.stream()
        .flatMap(reservation -> reservation.getMembers().stream())
        .collect(toList());
  }
}
