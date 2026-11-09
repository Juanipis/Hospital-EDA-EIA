package hospital;

import java.util.Arrays;

public class Historial {
	private String[] enfermedades;
	private String[] operaciones;
	private String[] alergias;
	private String citaId;
	
	public String getIdCita() {
		return citaId;
	}
	
	public Historial(String[] enfermedades, String[] operaciones, String[] alergias, String citaId) {
		super();
		this.enfermedades = enfermedades;
		this.operaciones = operaciones;
		this.alergias = alergias;
		this.citaId = citaId;
	}
	

	@Override
	public String toString() {
		return "Historial [Enfermedades = " + Arrays.toString(enfermedades) + ", Operaciones="
				+ Arrays.toString(operaciones) + ", Alergias=" + Arrays.toString(alergias) + ", CitaId=" + citaId + "]";
	}
}
