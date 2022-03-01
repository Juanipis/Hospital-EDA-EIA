package hospital;

public class Paciente extends Persona {
	private String poliza;
	private String[] sintomas;
	private int triaje;
	private String[] acompañantes;
	protected int edad;
	protected String sexo;
	protected String tipoSangre;
	protected Historial historial;

	public Paciente(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje, String[] acompañantes,
					int edad, String sexo, String tipoSangre, Historial historial) {
		super(nombre, apellido, cc);
		this.poliza = poliza;
		this.sintomas = sintomas;
		this.triaje = triaje;
		this.acompañantes = acompañantes;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
		this.historial = historial;
	}
	
	//Setters & Getters
	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String[] getSintomas() {
		return sintomas;
	}

	public void setSintomas(String[] sintomas) {
		this.sintomas = sintomas;
	}

	public int getTriaje() {
		return triaje;
	}

	public void setTriaje(int triaje) {
		this.triaje = triaje;
	}

	public String[] getAcompañantes() {
		return acompañantes;
	}

	public void setAcompañantes(String[] acompañantes) {
		this.acompañantes = acompañantes;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public String getTipoSangre() {
		return tipoSangre;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
	
}
