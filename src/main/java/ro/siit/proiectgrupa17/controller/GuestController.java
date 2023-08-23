package ro.siit.proiectgrupa17.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
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
    public String createGuests(@RequestParam("firstName") @NotNull String firstName,
                               @RequestParam("lastName") @NotNull String lastName,
                               @RequestParam("cnp") @NotNull long cnp,
                               @RequestParam("phoneNumber") @NotNull String phoneNumber) {
        if (firstName == null || lastName == null || phoneNumber == null) {
            throw new IllegalArgumentException("Fields cannot be null");
        }

        Guest guest = Guest.builder()
                .firstName(firstName)
                .lastName(lastName)
                .cnp(cnp)
                .phoneNumber(phoneNumber)
                .build();

        return guestService.createGuest(guest);
    }
    @PutMapping("/updateGuest/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String updateGuest(@PathVariable("id") Integer id, @RequestParam("cnp") long cnp) {
        Guest existingGuest = guestService.findById(id);

        if (existingGuest == null) {
            return "Guest not found";
        }

        existingGuest.setCnp(cnp);
        guestService.updateGuest(existingGuest);

        return "Guest CNP updated successfully";
    }

    @DeleteMapping("/deleteGuest/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String deleteGuest(@PathVariable("id") Integer id) {
        Guest existingGuest = guestService.findById(id);

        if (existingGuest == null) {
            return "Guest not found";
        }

        guestService.deleteGuest(existingGuest);
        return "Guest deleted";

    }

}
