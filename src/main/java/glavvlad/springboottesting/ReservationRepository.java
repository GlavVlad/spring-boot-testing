package glavvlad.springboottesting;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	Collection<Reservation> findByName(String name);
}
