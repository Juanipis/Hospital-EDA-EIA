package hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
					int edad, String sexo, String tipoSangre) throws IOException {
		super(nombre, apellido, cc);
		this.poliza = poliza;
		this.sintomas = sintomas;
		this.triaje = triaje;
		this.acompanantes = acompanantes;
		this.edad = edad;
		this.sexo = sexo;
		this.tipoSangre = tipoSangre;
		this.historial = new ArrayList<Historial>();
		try {
			this.recuperarHistorial();
		}catch(FileNotFoundException e) {
			Main.crearFichero(cc, 1);
		}
		
	}
	private void recuperarHistorial() throws IOException, FileNotFoundException {
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
	
	public int getIndexAcompanante(String acompanante) throws NoAcompanantesPaciente {
		int c = 0;
		while((c< this.acompanantes.length) && this.acompanantes[c] != null && !(this.acompanantes[c].equals(nombre)) ) {
			c++;
		}
		if(c!=this.acompanantes.length && this.acompanantes[c].equals(nombre)) {
			return c;
		}else {
			throw new NoAcompanantesPaciente();
		}
	}

	public void addAcompanantes(String acompanante) { //Modificar para no adicionar acompanantes repetidos
		this.acompanantes = Arrays.copyOf(this.acompanantes, this.acompanantes.length+1);
		this.acompanantes[acompanantes.length-1] = acompanante;
	}
	public void eliminarAcompanante(String acompanante) throws NoAcompanantesPaciente { //Crear excepcion en caso de que no exista el acompanante
		String[] temp = new String[this.acompanantes.length-1];
		int index = this.getIndexAcompanante(acompanante);
		int arT = 0;
		int arO = 0;
		
		while(arT < temp.length) {
			if(arT == index) {
				arO++;
			}
			temp[arT] = this.acompanantes[arO];
			arT++;
			arO++;
		}
		this.acompanantes = temp;	
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

	public void addHistorial(String[] enfermedades, String[] operaciones, String[] alergias, String citaId) throws FileNotFoundException, IOException {
		historial.add(new Historial(enfermedades, operaciones, alergias, citaId));
		StringBuilder bld = new StringBuilder();
		for (int i = 0; i < enfermedades.length; i++) {
			if(i != enfermedades.length-1) {
				bld.append(enfermedades[i] + ";");
			}else {
				bld.append(enfermedades[i]);
			}
		}
		bld.append(",");
		for (int i = 0; i < operaciones.length; i++) {
			if(i != operaciones.length-1) {
				bld.append(operaciones[i] + ";");
			}else {
				bld.append(operaciones[i]);
			}
		}
		bld.append(",");
		for (int i = 0; i < alergias.length; i++) {
			if(i != alergias.length-1) {
				bld.append(alergias[i] + ";");
			}else {
				bld.append(alergias[i]);
			}
		}
		bld.append("," + citaId);
		Main.escrituraFicheroUltimaLinea(CC, bld.toString(), 1);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: " + apellido + ", CC: " + CC;
	}
	
	

}
