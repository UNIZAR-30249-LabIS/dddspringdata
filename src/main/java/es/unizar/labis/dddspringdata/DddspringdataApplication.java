package es.unizar.labis.dddspringdata;

import es.unizar.labis.dddspringdata.application.ServicioPrueba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // Necesario para tener transacciones en servicios/facades
public class DddspringdataApplication {

	@Autowired
	private ServicioPrueba servicioPrueba;

	public static void main(String[] args) {
		SpringApplication.run(DddspringdataApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return (args) -> {
			servicioPrueba.test();
		};
	}
}
