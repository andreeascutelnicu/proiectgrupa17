package ro.siit.proiectgrupa17.repository;

import org.springframework.stereotype.Repository;
import ro.siit.proiectgrupa17.model.Guest;

import java.util.List;
@Repository
public class GuestRepository {
    public List<Guest> findAllGuests() {
        Guest guest1 = Guest.builder()
                .cnp(1234L)
                .firstName("George")
                .lastName("Toader")
                .phoneNumber("0758444444")
                .build();
        return List.of(guest1);
    }

}
