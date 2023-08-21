package ro.siit.proiectgrupa17.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.siit.proiectgrupa17.model.Guest;
import ro.siit.proiectgrupa17.repository.GuestRepository;
import ro.siit.proiectgrupa17.service.GuestService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GuestController {

    private final GuestService guestService;

    @GetMapping("/guests")
    public String listGuests(Model model) {
        List<Guest> guests = guestService.findAll();
        model.addAttribute("guests", guests);
        return "guests";
    }

    @GetMapping("/guests/{id}")
    @ResponseBody
    public Guest findGuestById(@PathVariable("id") int id) {
        return guestService.findById(id);
    }

    @PostMapping("/guests")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createGuests(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("cnp") long cnp,
                               @RequestParam("phoneNumber") String phoneNumber) {
        Guest guest = Guest.builder()
                .firstName(firstName)
                .lastName(lastName)
                .cnp(cnp)
                .phoneNumber(phoneNumber)
                .build();

        return guestService.createGuest(guest);
    }

}
