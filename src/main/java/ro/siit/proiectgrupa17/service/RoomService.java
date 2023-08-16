package ro.siit.proiectgrupa17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ro.siit.proiectgrupa17.model.Room;
import ro.siit.proiectgrupa17.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoomService {
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Value("${rate.discount}")
    private double discount;

    private RoomRepository roomRepository;

    public List<Room> findAvailableRooms() {
        List<Room> allRooms = roomRepository.findAllRooms();
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : allRooms) {
            if (!room.isReserved()) {
                room.setRate(room.getRate() / (1 + discount/100));
                availableRooms.add(room);
            }
        }
        if (availableRooms.isEmpty())
            throw new RuntimeException("No available rooms");
        return availableRooms;
    }

}
