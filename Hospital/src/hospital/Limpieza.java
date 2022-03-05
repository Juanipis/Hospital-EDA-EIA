package hospital;

import java.util.Arrays;

import hospital.NoExisteSala.SalaLimpia;

public class Limpieza extends Personal {

	public Limpieza(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC, disponible);
	}
	
	
	public void hacerLimpieza(String CC, String idSala) throws SalaLimpia {
		Sala[] salas = new Sala[0];
		for (int i = 0; i < salas.length; i++) {
			if (salas[i].getLimpia() == false) {
				salas[i].setLimpia(true);
			}else {
				throw new SalaLimpia(idSala);
			}
		}
	}
	

}
