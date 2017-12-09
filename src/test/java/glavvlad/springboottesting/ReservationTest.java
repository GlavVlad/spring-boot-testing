package glavvlad.springboottesting;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Vlad on 09.12.17.
 */
public class ReservationTest {

	@Test
	public void creation() {
		Reservation r = new Reservation(1L, "Jane");
		Assert.assertEquals(r.getId(), (Long) 1L);
		Assert.assertEquals(r.getName(), "Jane");
		Assert.assertThat(r.getId(), Matchers.equalTo(1L));
		Assertions.assertThat(r.getId()).isEqualTo(1L);
		Assertions.assertThat(r.getName()).isNotBlank();


	}
}
