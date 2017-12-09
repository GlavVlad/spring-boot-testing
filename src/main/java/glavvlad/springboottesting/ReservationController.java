package glavvlad.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class ReservationController {

	@Autowired
	private ReservationRepository repository;

	@GetMapping(value = "/reservations", produces = APPLICATION_JSON_UTF8_VALUE)
	Collection<Reservation> getReservations() {
		return repository.findAll();
	}
}
