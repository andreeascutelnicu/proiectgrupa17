package ro.siit.proiectgrupa17.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.siit.proiectgrupa17.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
