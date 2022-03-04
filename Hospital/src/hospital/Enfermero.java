package hospital;

import java.util.Arrays;

//push

public class Enfermero extends Personal {

	public Enfermero(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC, disponible);
	}

	public void addEnfermero(String nombre, String apellido, String CC, boolean disponible) throws EPersonal {
		Enfermero[] enfermeros = new Enfermero[0];
		for (int i = 0; i < enfermeros.length; i++) {
			if (enfermeros[i].getCC().equals(CC)) {
				throw new EPersonal("Esta persona ya se encuentra en el hospital");
			} else {
				enfermeros = Arrays.copyOf(enfermeros, enfermeros.length - 1);
				enfermeros[enfermeros.length - 1] = new Enfermero(nombre, apellido, CC, disponible);
			}
		}
	}

	public void eliminarEnfermero(String nombre, String apellido, String CC, boolean disponible) {
		Enfermero[] enfermeros = new Enfermero[0];
		for (int i = 0; i < enfermeros.length; i++) {
			if (enfermeros[i].getNombre().equals(nombre)) {
				enfermeros[enfermeros.length - 1] = new Enfermero(nombre, apellido, CC, disponible);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
