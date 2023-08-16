package ro.siit.proiectgrupa17.repository;

import org.springframework.stereotype.Repository;
import ro.siit.proiectgrupa17.model.Room;

import java.util.List;

@Repository
public class RoomRepository {
    public List<Room> findAllRooms() {
        Room room1 = Room.builder()
                .capacity(2)
                .rate(10)
                .roomNumber(1)
                .isReserved(false)
                .isModern(true)
                .build();
        Room room2 = Room.builder()
                .capacity(2)
                .rate(10)
                .roomNumber(1)
                .isReserved(true)
                .isModern(true)
                .build();
        return List.of(room1, room2);
    }

}
