package glavvlad.springboottesting;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ReservationJpaTest {

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void mapping() {
		Reservation jane = entityManager.persistFlushFind(new Reservation(null, "Jane"));
		Assertions.assertThat(jane.getName()).isEqualTo("Jane");
		Assertions.assertThat(jane.getId()).isNotNull();
		Assertions.assertThat(jane.getId()).isGreaterThan(0);
	}
}
