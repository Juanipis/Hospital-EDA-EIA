package hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

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
					int edad, String sexo, String tipoSangrel) throws IOException {
		super(nombre, apellido, cc);
		this.poliza = poliza;
		this.sintomas = sintomas;
		this.triaje = triaje;
		this.acompanantes = acompanantes;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
		this.historial = new ArrayList<Historial>();
		this.recuperarHistorial();
	}
	private void recuperarHistorial() throws IOException {
		BufferedReader fichero = new BufferedReader(new FileReader(Main.recuperarFichero(this.CC, 1)));
		String histActual;
		while( ( histActual = fichero.readLine()) != null) {
			String[] partesCita = histActual.split(",");
			if(partesCita.length == 4) {
				String[] enfermedades = partesCita[0].split(";");
				String[] operaciones = partesCita[1].split(";");
				String[] alergias = partesCita[2].split(";");
				String citaId = partesCita[3];
				historial.add(new Historial(enfermedades,operaciones,alergias,citaId));
			}        
		}
		fichero.close();
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
