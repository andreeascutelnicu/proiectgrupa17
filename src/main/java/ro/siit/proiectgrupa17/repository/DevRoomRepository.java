package ro.siit.proiectgrupa17.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ro.siit.proiectgrupa17.model.Room;

import java.util.List;
@Repository
@Profile("dev")
public class DevRoomRepository {
    public List<Room> findAllRooms() {
        Room room1 = Room.builder()
                .capacity(20)
                .rate(100)
                .roomNumber(10)
                .isReserved(false)
                .isModern(true)
                .build();
        Room room2 = Room.builder()
                .capacity(2000)
                .rate(100000)
                .roomNumber(10000)
                .isReserved(true)
                .isModern(true)
                .build();
        return List.of(room1, room2);
    }
}
