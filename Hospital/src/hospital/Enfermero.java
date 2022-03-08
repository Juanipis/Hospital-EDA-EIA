package hospital;

import java.util.Arrays;

//push

public class Enfermero extends Personal {

	public Enfermero(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC, disponible);
	}
	
	public String toString() {
		return (this.getNombre() + " : " + this.getApellido() + " : " + this.getCC() + " : " + this.getDisponible() + "\n");
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
		
	}
}