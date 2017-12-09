package glavvlad.springboottesting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest
@RunWith(SpringRunner.class)
public class ReservationControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@Configuration
//	public static class MyConfig {
//		@Bean
//		ReservationRepository repository() {
//			ReservationRepository mock = Mockito.mock(ReservationRepository.class);
//			Mockito.when(mock.findAll()).thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));
//			return mock;
//		}
//	}

	@MockBean
	private ReservationRepository repository;

	@Test
	public void getReservation() throws Exception {
		Mockito.when(repository.findAll()).thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));

		mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath("@.[0].name").value("Jane"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
