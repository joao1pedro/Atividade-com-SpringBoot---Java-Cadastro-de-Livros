package uf.br.webstore.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController

public class AgendaVacinaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaVacinaApplication.class, args);
	}

}
