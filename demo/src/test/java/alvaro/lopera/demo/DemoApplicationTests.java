package alvaro.lopera.demo;

import static org.mockito.ArgumentMatchers.isA;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import alvaro.lopera.demo.Controlador.Controller;
import alvaro.lopera.demo.Entidades.Nave;
import alvaro.lopera.demo.Repositorio.NaveRepository;
import jakarta.transaction.Status;

@WebMvcTest ( Controller.class )
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MockMvc MOCKmVC;

	@Autowired 
	ObjectMapper mapper;

	@MockBean
	NaveRepository nr;

	Nave n1 = new Nave(1L, 1);
	Nave n2 = new Nave(2l, 2);
	Nave n3 = new Nave(3L, 3);

	@Test 
	public void getAllNavesT ( ) throws Exception {

		List<Nave> naves = new ArrayList<>();

		naves.add(n1);
		naves.add(n2);

		Mockito.when(nr.findAll()).thenReturn(naves);


		MOCKmVC.perform(MockMvcRequestBuilders.get("/Nave").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)))
		.andExpect(jsonPath("$[1].id", is(2))) ;



	}


}
