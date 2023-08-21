package ro.siit.proiectgrupa17.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.siit.proiectgrupa17.model.Guest;
import ro.siit.proiectgrupa17.repository.GuestRepository;

import java.util.List;

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
}
