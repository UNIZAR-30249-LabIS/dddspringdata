package es.unizar.labis.dddspringdata.application;


import es.unizar.labis.dddspringdata.DddspringdataApplication;
import es.unizar.labis.dddspringdata.domain.Cliente;
import es.unizar.labis.dddspringdata.domain.Persona;
import es.unizar.labis.dddspringdata.domain.PersonaRepository;
import es.unizar.labis.dddspringdata.domain.Trabajador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.Optional;


@Service
public class ServicioPrueba {
	private final PersonaRepository<Persona> personaRepository;
	private static final Logger log = LoggerFactory.getLogger(DddspringdataApplication.class);


	public ServicioPrueba(PersonaRepository pR) {
		this.personaRepository = pR;
	}

	public void test() {

		var abel = new Cliente("Abel");
		abel.setNumeroDeProductosComprados(5);
		var blanca = new Cliente("Blanca");
		blanca.setNumeroDeProductosComprados(3);
		var cosme = new Trabajador("Cosme");
		cosme.setDepartamento("Ventas");

		personaRepository.saveAll(Arrays.asList(abel, blanca, cosme));

		var unAbel = personaRepository.findTrabajadorByNombre("Abel");
		log.info("No hay Abel trabajador, por tanto esto debe ser null: " + unAbel);

		var otroAbel = personaRepository.findClienteByNombre("Abel");
		log.info("Sí que hay Abel cliente, por tanto esto debe ser Abel: " + otroAbel.getNombre());
		log.info("Y como cliente, este Abel tiene un número de productos comprados: " + otroAbel.getNumeroDeProductosComprados());

		Persona tercerAbel = personaRepository.findByNombre("Abel");
		log.info("Abel es una persona, así que lo encontramos. Este será su nombre: " + tercerAbel.getNombre());
		log.info("Y aunque lo hemos buscado como persona, como cliente, este Abel tiene un número de productos comprados: " + otroAbel.getNumeroDeProductosComprados());


		Optional<Persona> esteEsElAbelOriginal = personaRepository.findById(abel.getId());
		log.info("Los métodos por defecto también funcionan. Este es el nombre del Abel guardado: " + esteEsElAbelOriginal.get().getNombre());

		// Podemos tratar uniformemente a todas las personas devueltas, aunque sean de distintas subclases
		for (var persona:personaRepository.findAll()) {
			log.info("Persona : " + persona.getNombre());
		}
	}
}
