package es.unizar.labis.dddspringdata.application;


import es.unizar.labis.dddspringdata.DddspringdataApplication;
import es.unizar.labis.dddspringdata.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class ServicioPrueba {
	private final PersonaRepository personaRepository;
	private static final Logger log = LoggerFactory.getLogger(DddspringdataApplication.class);

	public ServicioPrueba(PersonaRepository pR) {
		this.personaRepository = pR;
	}

	public void testPersona() {

		var abel = new Cliente("Abel");
		abel.setNumeroDeProductosComprados(5);
		var blanca = new Cliente("Blanca");
		blanca.setNumeroDeProductosComprados(3);
		var cosme = new Trabajador("Cosme");
		cosme.setDepartamento("Ventas");
		var cosme2 = new Cliente("Cosme");
		cosme2.setNumeroDeProductosComprados(12);

		personaRepository.saveAll(Arrays.asList(abel, blanca, cosme, cosme2));

		var unAbel = personaRepository.findTrabajadorByNombre("Abel");
		log.info("No hay Abel trabajador, por tanto esto debe ser null: " + unAbel);

		var otroAbel = personaRepository.findClienteByNombre("Abel");
		log.info("Sí que hay Abel cliente, por tanto esto debe ser Abel: " + otroAbel.getNombre());
		log.info("Y como cliente, este Abel tiene un número de productos comprados: " + otroAbel.getNumeroDeProductosComprados());

		Persona tercerAbel = personaRepository.findFirstByNombre("Abel");
		log.info("Abel es una persona, así que lo encontramos. Este será su nombre: " + tercerAbel.getNombre());
		log.info("Y aunque lo hemos buscado como persona, como cliente, este Abel tiene un número de productos comprados: " + otroAbel.getNumeroDeProductosComprados());


		Optional<Persona> esteEsElAbelOriginal = personaRepository.findById(abel.getId());
		log.info("Los métodos por defecto también funcionan. Este es el nombre del Abel guardado: " + esteEsElAbelOriginal.get().getNombre());

		log.info("Podemos tratar uniformemente a todas las personas devueltas, aunque sean de distintas subclases.");
		for (var persona:personaRepository.findAll()) {
			log.info("Persona : " + persona.getNombre());
		}

		// Hay dos Cosmes, uno es trabajador y otro cliente
		for (var unCosme:personaRepository.findAllByNombre("Cosme")) {
			log.info("Este Cosme es " + unCosme.getClass().getName() + " y su ID es " + unCosme.getId());
		}

		Persona diana = new Cliente("Diana");
		personaRepository.save(diana);

	}

}
