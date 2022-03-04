package hospital;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hospital {
	private AgendaHospital agendaHospital;
	private ArrayList<Paciente> pacientes;
	private ArrayList<Medico> medicos;
	private ArrayList<Limpieza> personalLimpieza;
	private ArrayList<Enfermero> enfermeros;
	
	public Hospital() throws IOException {
		this.agendaHospital = new AgendaHospital();
		this.medicos = new ArrayList<Medico>();
		this.pacientes = new ArrayList<Paciente>();
		this.personalLimpieza = new ArrayList<Limpieza>();
		this.enfermeros = new ArrayList<Enfermero>();
		
		this.cargarDatos();
	}
	
	private void cargarDatos() throws IOException {
		//Cargamos Personal
		BufferedReader fichero = new BufferedReader(new FileReader(Main.recuperarFichero("personal.txt")));
		String citaAct;
		while( ( citaAct = fichero.readLine()) != null) {
			String[] partesPersonal = citaAct.split(",");
			if(partesPersonal[0].equals("0") && partesPersonal.length == 8) { // Es medico
				medicos.add(new Medico(partesPersonal[1], partesPersonal[2], partesPersonal[3], Boolean.getBoolean(partesPersonal[4]), partesPersonal[5], Boolean.getBoolean(partesPersonal[6])));
			}
			else if(partesPersonal[0].equals("1") && partesPersonal.length == 5) { // Es personal Limpieza
				personalLimpieza.add(new Limpieza(partesPersonal[1], partesPersonal[2],partesPersonal[3],Boolean.getBoolean(partesPersonal[4])));
			}
			else if(partesPersonal[0].equals("2") && partesPersonal.length == 5) { // Es enfermero
				enfermeros.add(new Enfermero(partesPersonal[1], partesPersonal[2],partesPersonal[3],Boolean.getBoolean(partesPersonal[4])));
			}
			
			}
		fichero.close();
	}
	
	public boolean generarCita(String CCPaciente, String CCMedico,int[] fechaInicio, int[] fechaFinal) throws FormatoFechaInvalida, IOException, NoHayDisponibilidadCita {
			return this.agendaHospital.generarCita(CCPaciente, CCMedico, fechaInicio, fechaFinal);
	}
	//Con el mismo medico
	public boolean modificarCita(String idCita, int[] fechaInicio, int[] fechaFinal) throws FormatoFechaInvalida, CitaNoExiste, PersonaNoCitas, IOException, NoHayDisponibilidadCita, MedicoNoCitas{
		if(fechaInicio.length == 5 && fechaFinal.length ==5) {
			Calendar fi = new GregorianCalendar(fechaInicio[0], fechaInicio[1], fechaInicio[2], fechaInicio[3], fechaInicio[4]);
			Calendar ff = new GregorianCalendar(fechaFinal[0], fechaFinal[1], fechaFinal[2], fechaFinal[3], fechaFinal[4]);
			boolean condicion = this.agendaHospital.modificarCita(idCita, fi.getTime(), ff.getTime());
			return condicion;
			
		}else {
			throw new FormatoFechaInvalida();
		}
	}	
	//Con otro medico
	public boolean modificarCita(String idCita,String CCMedico, int[] fechaInicio, int[] fechaFinal) throws FormatoFechaInvalida, CitaNoExiste, PersonaNoCitas, IOException, NoHayDisponibilidadCita{
		if(fechaInicio.length == 5 && fechaFinal.length ==5) {
			Calendar fi = new GregorianCalendar(fechaInicio[0], fechaInicio[1], fechaInicio[2], fechaInicio[3], fechaInicio[4]);
			Calendar ff = new GregorianCalendar(fechaFinal[0], fechaFinal[1], fechaFinal[2], fechaFinal[3], fechaFinal[4]);
			boolean condicion = this.agendaHospital.modificarCita(idCita,CCMedico,fi.getTime(), ff.getTime());
			return condicion;
			
		}else {
			throw new FormatoFechaInvalida();
		}
	}
	public boolean cancelarCita(String idCita) throws CitaNoExiste, FileNotFoundException, IOException {
		this.agendaHospital.cancelarCita(idCita);
		return true;
		
	}
	
	public Cita[] getCitas() {
		return this.agendaHospital.getCitas();
	}
	public Cita[] getCitasMedico(String CC) throws MedicoNoCitas {
		return this.agendaHospital.buscarCitaCedulaMedico(CC);
	}
	public Cita[] getCitasPaciente(String CCPaciente) throws PersonaNoCitas {
		return this.agendaHospital.buscarCitaCedulaPaciente(CCPaciente);
	}
	
	public Cita buscarCitaId(String idFormula) throws CitaNoExiste {
		return this.agendaHospital.buscarCitaId(idFormula);
	}
	
	
	//Metodos relacionados con medicos
	public Medico getMedico(String CC){
		int index = 0;
		while(index < medicos.size() && medicos.get(index) != null && !medicos.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < medicos.size() && medicos.get(index) != null && medicos.get(index).getCC().equals(CC)) {
			return medicos.get(index);
		}else {
			return null;
		}
	}
	
	public int getMedicoIndex(String CC) throws NoExistePersonal {
		int index = 0;
		while(index < medicos.size() && medicos.get(index) != null && !medicos.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < medicos.size() && medicos.get(index) != null && medicos.get(index).getCC().equals(CC)) {
			return index;
		}else {
			throw new NoExistePersonal(CC);
		}
	}
	
	public void addMedico(String nombre, String apellido, String CC, boolean disponible, String esp, boolean pres) throws FileNotFoundException, IOException, ExistePersonal{
		if(this.getMedico(CC) == null) {
			medicos.add(new Medico(nombre, apellido, CC, disponible, esp, pres));
			//Para el fichero
			StringBuilder bld = new StringBuilder();
			bld.append("0" + ",");
			bld.append(nombre + ",");
			bld.append(apellido + ",");
			bld.append(CC + ",");
			bld.append(disponible+ ",");
			bld.append(esp+ ",");
			bld.append(pres);
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString());
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarMedico(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		medicos.remove(this.getMedicoIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC);
	}
	
	//Metodos relacionados con personal limpieza
	public Limpieza getPersonalLimpieza(String CC){
		int index = 0;
		while(index < personalLimpieza.size() && personalLimpieza.get(index) != null && !personalLimpieza.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < personalLimpieza.size() && personalLimpieza.get(index) != null && personalLimpieza.get(index).getCC().equals(CC)) {
			return personalLimpieza.get(index);
		}else {
			return null;
		}
	}
	
	public int getPersonalLimpiezaIndex(String CC) throws NoExistePersonal {
		int index = 0;
		while(index < personalLimpieza.size() && personalLimpieza.get(index) != null && !personalLimpieza.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < personalLimpieza.size() && personalLimpieza.get(index) != null && personalLimpieza.get(index).getCC().equals(CC)) {
			return index;
		}else {
			throw new NoExistePersonal(CC);
		}
	}
	
	public void addPersonalLimpieza(String nombre, String apellido, String CC, boolean disponible) throws FileNotFoundException, IOException, ExistePersonal{
		if(this.getPersonalLimpieza(CC) == null) {
			personalLimpieza.add(new Limpieza(nombre, apellido, CC, disponible));
			//Para el fichero
			StringBuilder bld = new StringBuilder();
			bld.append("1" + ",");
			bld.append(nombre + ",");
			bld.append(apellido + ",");
			bld.append(CC + ",");
			bld.append(disponible);
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString());
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarPersonalLimpieza(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		personalLimpieza.remove(this.getPersonalLimpiezaIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC);
	}
	
	//Metodos relacionados con efermeros
	public Enfermero getEnfermero(String CC){
		int index = 0;
		while(index < enfermeros.size() && enfermeros.get(index) != null && !enfermeros.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < enfermeros.size() && enfermeros.get(index) != null && enfermeros.get(index).getCC().equals(CC)) {
			return enfermeros.get(index);
		}else {
			return null;
		}
	}
	
	public int getEnfermerosIndex(String CC) throws NoExistePersonal {
		int index = 0;
		while(index < enfermeros.size() && enfermeros.get(index) != null && !enfermeros.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < enfermeros.size() && enfermeros.get(index) != null && enfermeros.get(index).getCC().equals(CC)) {
			return index;
		}else {
			throw new NoExistePersonal(CC);
		}
	}
	
	public void addEnfermeros(String nombre, String apellido, String CC, boolean disponible) throws FileNotFoundException, IOException, ExistePersonal{
		if(this.getEnfermero(CC) == null) {
			enfermeros.add(new Enfermero(nombre, apellido, CC, disponible));
			//Para el fichero
			StringBuilder bld = new StringBuilder();
			bld.append("2" + ",");
			bld.append(nombre + ",");
			bld.append(apellido + ",");
			bld.append(CC + ",");
			bld.append(disponible);
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString());
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarEnfermero(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		enfermeros.remove(this.getEnfermerosIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC);
	}
	
	//Metodos relacionados con salas
	
}
