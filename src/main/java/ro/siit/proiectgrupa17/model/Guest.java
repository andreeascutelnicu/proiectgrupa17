package ro.siit.proiectgrupa17.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Guest {
    private long cnp;
    private String firstName;
    private String lastName;
    private String phoneNumber;
}
