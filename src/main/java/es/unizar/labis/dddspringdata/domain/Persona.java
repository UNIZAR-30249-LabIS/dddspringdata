package es.unizar.labis.dddspringdata.domain;

import javax.persistence.*;

@Entity
public abstract class Persona extends PersonaAbstracta {

	private String nombre;

	public Persona() {}

	public Persona(String nombre) {
		this.nombre = nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}

