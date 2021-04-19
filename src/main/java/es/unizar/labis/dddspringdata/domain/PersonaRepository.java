package es.unizar.labis.dddspringdata.domain;

import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository<T extends Persona> extends CrudRepository<T, Long> {
	Trabajador findTrabajadorByNombre(String name);
	Cliente findClienteByNombre(String name);
	Persona findByNombre(String name);
}

