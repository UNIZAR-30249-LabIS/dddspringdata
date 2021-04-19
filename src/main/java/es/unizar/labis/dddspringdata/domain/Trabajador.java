package es.unizar.labis.dddspringdata.domain;

import javax.persistence.Entity;

@Entity
public class Trabajador extends Persona {
	private String departamento;

	public Trabajador() {}

	public Trabajador(String nombre) {
		super(nombre);
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String d) {
		departamento = d;
	}
}
