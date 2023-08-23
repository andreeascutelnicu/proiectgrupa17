package ro.siit.proiectgrupa17.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.siit.proiectgrupa17.model.Guest;
import ro.siit.proiectgrupa17.repository.GuestRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {

    private final GuestRepository guestRepository;

    public List<Guest> findAll() {

        return guestRepository.findAll();
    }

    public String createGuest(Guest guest) {

        return "Create guest with id: " + guestRepository.save(guest).getId();
    }

    public Guest findById(int id) {
        return guestRepository.findById(id).orElseThrow(() -> new RuntimeException("Guest not found"));
    }

    public String updateGuest(Guest existingGuest) {
        Guest updatedGuest = guestRepository.save(existingGuest);
        if (updatedGuest != null) {
            return "Guest updated successfully";
        } else {
            return "Failed to update guest";
        }
    }

    public String deleteGuest(Guest guest) {
        if (guestRepository.existsById(guest.getId())) {
            guestRepository.delete(guest);
            return "Deleting guest with id: " + guest.getId();
        } else {
            return "Guest not found";
        }
    }
}
