package ro.siit.proiectgrupa17.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ro.siit.proiectgrupa17.model.Room;
import ro.siit.proiectgrupa17.service.RoomService;

import java.util.List;

@RestController
public class RoomController {
    private RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(value = "/rooms")
    public List<Room> findAvailableRooms() {
        return roomService.findAvailableRooms();
    }

}
