package es.unizar.labis.dddspringdata.domain;

import javax.persistence.*;

@Entity
public abstract class Persona {
	@Id
	@GeneratedValue(generator="increment")
	private Long id;
	private String nombre;

	public Persona() {}

	public Persona(String nombre) {
		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}

