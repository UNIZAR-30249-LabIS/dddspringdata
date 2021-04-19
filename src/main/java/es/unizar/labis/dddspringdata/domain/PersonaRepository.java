package es.unizar.labis.dddspringdata.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	Trabajador findTrabajadorByNombre(String name);
	Cliente findClienteByNombre(String name);
	Persona findFirstByNombre(String name);
	List<Persona> findAllByNombre(String name);
}

