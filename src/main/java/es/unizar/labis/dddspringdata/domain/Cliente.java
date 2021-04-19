package es.unizar.labis.dddspringdata.domain;

import javax.persistence.Entity;

@Entity
public class Cliente extends Persona {
	private int numeroDeProductosComprados;

	public Cliente() {}

	public Cliente(String nombre) {
		super(nombre);
	}

	public int getNumeroDeProductosComprados() {
		return numeroDeProductosComprados;
	}

	public void setNumeroDeProductosComprados(int num) {
		numeroDeProductosComprados = num;
	}
}
