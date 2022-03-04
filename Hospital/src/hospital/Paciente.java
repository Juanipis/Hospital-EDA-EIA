package hospital;

import java.util.ArrayList;

public class Paciente extends Persona {
	private String poliza;
	private String[] sintomas;
	private int triaje;
	private String[] acompanantes;
	protected int edad;
	protected String sexo;
	protected String tipoSangre;
	protected ArrayList<Historial> historial;

	public Paciente(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje, String[] acompanantes,
					int edad, String sexo, String tipoSangre, Historial historial) {
		super(nombre, apellido, cc);
		this.poliza = poliza;
		this.sintomas = sintomas;
		this.triaje = triaje;
		this.acompanantes = acompanantes;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
		this.historial = new ArrayList<Historial>();
	}
	public void inicializarHistorial() {
		//File historial = new File();
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

	public Historial[] getHistorial() {
		return historial.toArray(new Historial[historial.size()]);
	}
/*
	public void setHistorial(Historial historial) {
		this.historial = historial;
	}
*/
}
