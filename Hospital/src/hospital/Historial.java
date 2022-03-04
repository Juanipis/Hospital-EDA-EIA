package hospital;

import java.util.Arrays;

public class Historial {
	private String[] enfermedades;
	private String[] operaciones;
	private String[] alergias;
	private Cita cita;
	
	public Cita getCita() {
		return cita;
	}
	
	public Historial(String[] enfermedades, String[] operaciones, String[] alergias, Cita cita) {
		super();
		this.enfermedades = enfermedades;
		this.operaciones = operaciones;
		this.alergias = alergias;
		this.cita = cita;
	}
	
	public void addHistorial(String[] enfermedades, String[] operaciones, String[] alergias, Cita cita){
		Historial[] historial = new Historial[0];
		for(int i = 0; i < historial.length; i++) {
			if(historial[i].getCita().equals(cita)) {	
			}else {
				historial = Arrays.copyOf(historial, historial.length-1);
				historial[historial.length-1] = new Historial(enfermedades, operaciones, alergias, cita);
			}
		}
	}
}
