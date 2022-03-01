package hospital;

public class Historial {
	private String[] enfermedades;
	private String[] operaciones;
	private String[] alergias;
	//private Cita cita;
	
	public Historial(String[] enfermedades, String[] operaciones, String[] alergias) {
		super();
		this.enfermedades = enfermedades;
		this.operaciones = operaciones;
		this.alergias = alergias;
	}
}
