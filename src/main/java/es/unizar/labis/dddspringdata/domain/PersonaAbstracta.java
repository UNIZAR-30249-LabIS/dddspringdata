package es.unizar.labis.dddspringdata.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class PersonaAbstracta {

	@Id
	@GeneratedValue(generator="increment")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public abstract void setNombre(String nombre);

	public abstract String getNombre();

}
