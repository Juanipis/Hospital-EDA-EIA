package hospital;

public class Paciente extends Persona {
	private String poliza;
	private String[] sintomas;
	private int triaje;
	private String[] acompanantes;
	protected int edad;
	protected String sexo;
	protected String tipoSangre;
	protected Historial historial;

	//Historial no se le entrega al constructor ya que s epuede crear un paciente nuevo que no tenga un historial, todavia
	public Paciente(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje, String[] acompanantes,
					int edad, String sexo, String tipoSangre) {
		super(nombre, apellido, cc);
		this.poliza = poliza;
		this.sintomas = sintomas;
		this.triaje = triaje;
		this.acompanantes = acompanantes;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
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

	public String[] getAcompanantes() {
		return acompanantes;
	}

	public void setAcompanantes(String[] acompanantes) {
		this.acompanantes = acompanantes;
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
