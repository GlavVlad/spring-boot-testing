package glavvlad.springboottesting;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationRepositoryTest {

	@Autowired
	private ReservationRepository repository;

	@Test
	public void findByReservationName() {
		repository.save(new Reservation(null, "Jane"));
		Collection<Reservation> byName = repository.findByName("Jane");
		Assertions.assertThat(byName.size()).isEqualTo(1);
		Assertions.assertThat(byName.iterator().next().getId()).isGreaterThan(0);
		Assertions.assertThat(byName.iterator().next().getName()).isEqualTo("Jane");
	}
}
