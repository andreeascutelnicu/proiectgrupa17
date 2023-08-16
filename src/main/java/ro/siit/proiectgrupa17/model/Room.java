package ro.siit.proiectgrupa17.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
public class Room {
    private final int capacity;
    private int roomNumber;
    private boolean isModern;
    private boolean isReserved;
    private double rate;
}
