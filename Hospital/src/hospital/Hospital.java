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
	private ArrayList<Sala> salas;
	
	public Hospital() throws IOException {
		this.agendaHospital = new AgendaHospital();
		this.medicos = new ArrayList<Medico>();
		this.pacientes = new ArrayList<Paciente>();
		this.personalLimpieza = new ArrayList<Limpieza>();
		this.enfermeros = new ArrayList<Enfermero>();
		this.salas = new ArrayList<Sala>();
		this.cargarDatos();
	}
	
	private void cargarDatos() throws IOException {
		//Cargamos Personal
		BufferedReader fichero = new BufferedReader(new FileReader(Main.recuperarFichero("personal.txt", 0)));
		String lineaAct;
		while( ( lineaAct = fichero.readLine()) != null) {
			String[] partesPersonal = lineaAct.split(",");
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
		
		
		BufferedReader pacientesFich = new BufferedReader(new FileReader(Main.recuperarFichero("pacientes.txt", 0)));
		while((lineaAct = pacientesFich.readLine()) != null) {
			String[] partesPaciente = lineaAct.split(",");
			if(partesPaciente.length == 10) {
				pacientes.add(new Paciente(
						partesPaciente[0],
						partesPaciente[1],
						partesPaciente[2],
						partesPaciente[3],
						partesPaciente[4].split(";"),
						Integer.valueOf(partesPaciente[5]),
						partesPaciente[6].split(";"),
						Integer.valueOf(partesPaciente[7]),
						partesPaciente[8],
						partesPaciente[9]));
			}
		}
		
		
		
		
		BufferedReader ficheroSalas = new BufferedReader(new FileReader(Main.recuperarFichero("salas.txt", 0)));
		while( ( lineaAct = ficheroSalas.readLine()) != null) {
			String[] partesSala = lineaAct.split(",");
			if(partesSala.length == 6) {
				salas.add(new Sala(
						partesSala[0],
						Integer.valueOf(partesSala[1]),
						partesSala[2].split(";"),
						partesSala[3].split(";"),
						partesSala[4].split(";"),
						partesSala[5]));
			}
			
		}
		this.limpiezaArchivos(new BufferedReader [] {fichero,pacientesFich,ficheroSalas});
	}
	
	private void limpiezaArchivos(BufferedReader [] archivos) throws IOException {
		for(BufferedReader bf : archivos) {
			bf.close();
		}
	}
	
	private void cargarPersonal() throws IOException {
		BufferedReader fichero = new BufferedReader(new FileReader(Main.recuperarFichero("personal.txt", 0)));
		String lineaAct;
		while( ( lineaAct = fichero.readLine()) != null) {
			String[] partesPersonal = lineaAct.split(",");
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
	
	private void cargarPacientes() throws NumberFormatException, IOException {
		BufferedReader pacientesFich = new BufferedReader(new FileReader(Main.recuperarFichero("pacientes.txt", 0)));
		String lineaAct;
		while((lineaAct = pacientesFich.readLine()) != null) {
			String[] partesPaciente = lineaAct.split(",");
			if(partesPaciente.length == 10) {
				pacientes.add(new Paciente(
						partesPaciente[0],
						partesPaciente[1],
						partesPaciente[2],
						partesPaciente[3],
						partesPaciente[4].split(";"),
						Integer.valueOf(partesPaciente[5]),
						partesPaciente[6].split(";"),
						Integer.valueOf(partesPaciente[7]),
						partesPaciente[8],
						partesPaciente[9]));
			}
		}
		pacientesFich.close();
	}
	
	private void cargarSalas() throws IOException {
		BufferedReader ficheroSalas = new BufferedReader(new FileReader(Main.recuperarFichero("salas.txt", 0)));
		String lineaAct;
		while( ( lineaAct = ficheroSalas.readLine()) != null) {
			String[] partesSala = lineaAct.split(",");
			if(partesSala.length == 6) {
				salas.add(new Sala(
						partesSala[0],
						Integer.valueOf(partesSala[1]),
						partesSala[2].split(";"),
						partesSala[3].split(";"),
						partesSala[4].split(";"),
						partesSala[5]));
			}
			ficheroSalas.close();
		}
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
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString(), 0);
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarMedico(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		medicos.remove(this.getMedicoIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC, 0);
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
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString(), 0);
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarPersonalLimpieza(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		personalLimpieza.remove(this.getPersonalLimpiezaIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC, 0);
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
			Main.escrituraFicheroUltimaLinea("personal.txt", bld.toString(), 0);
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	
	public void eliminarEnfermero(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		enfermeros.remove(this.getEnfermerosIndex(CC));
		Main.eliminarAlgoFicheroId("personal.txt", CC, 0);
	}
	
	//Metodos relacionados con Pacientes
	public Paciente getPaciente(String CC){
		int index = 0;
		while(index < pacientes.size() && pacientes.get(index) != null && !pacientes.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < pacientes.size() && pacientes.get(index) != null && pacientes.get(index).getCC().equals(CC)) {
			return pacientes.get(index);
		}else {
			return null;
		}
	}
	
	public int getPacientesIndex(String CC) throws NoExistePersonal {
		int index = 0;
		while(index < pacientes.size() && pacientes.get(index) != null && !pacientes.get(index).getCC().equals(CC) ) {
			index++;
		}
		if(index < pacientes.size() && pacientes.get(index) != null && pacientes.get(index).getCC().equals(CC)) {
			return index;
		}else {
			throw new NoExistePersonal(CC);
		}
	}
	
	public void addPaciente(String nombre, String apellido, String CC, String poliza, String[] sintomas, int triaje, String[] acompanantes,
			int edad, String sexo, String tipoSangre) throws FileNotFoundException, IOException, ExistePersonal{
		if(this.getPaciente(CC) == null) {
			pacientes.add(new Paciente(nombre,apellido, CC, poliza, sintomas, triaje, acompanantes,edad, sexo, tipoSangre));
			//Para el fichero
			StringBuilder bld = new StringBuilder();
			bld.append(nombre + ",");
			bld.append(apellido + ",");
			bld.append(CC + ",");
			bld.append(poliza + ",");
			for (String st: sintomas) {
				bld.append(st + ";");
			}
			bld.append("," + triaje + ",");
			for(String acmp : acompanantes) {
				bld.append(acmp + ";");
			}
			bld.append("," + edad + ",");
			bld.append(sexo + ",");
			bld.append(tipoSangre);
			Main.escrituraFicheroUltimaLinea("pacientes.txt", bld.toString(), 0);
		}else {
			throw new ExistePersonal(CC);
		}		
	}
	public void eliminarPaciente(String CC) throws NoExistePersonal, FileNotFoundException, IOException {
		pacientes.remove(this.getPacientesIndex(CC));
		Main.eliminarAlgoFicheroId("pacientes.txt", CC, 0);
	}
	
	//Metodos relacionados con salas
	public Sala getSala(String idSala){
		int index = 0;
		while(index < salas.size() && salas.get(index) != null && !salas.get(index).getIdSala().equals(idSala) ) {
			index++;
		}
		if(index < salas.size() && salas.get(index) != null && salas.get(index).getIdSala().equals(idSala)) {
			return salas.get(index);
		}else {
			return null;
		}
	}
	public int getSalaIndex(String idSala) throws NoExistePersonal {
		int index = 0;
		while(index < salas.size() && salas.get(index) != null && !salas.get(index).getIdSala().equals(idSala) ) {
			index++;
		}
		if(index < salas.size() && salas.get(index) != null && salas.get(index).getIdSala().equals(idSala)) {
			return index;
		}else {
			throw new NoExistePersonal(idSala);
		}
	}
	public void addSala(String tipo, int capacidad, String[] medicamentosId, String[] equiposId, String[] pacientes,
			String idSala) throws FileNotFoundException, IOException, ExistePersonal{
		if(this.getPaciente(idSala) == null) {
			salas.add(new Sala(tipo, capacidad, medicamentosId, equiposId, pacientes, idSala));
			//Para el fichero
			StringBuilder bld = new StringBuilder();
			bld.append(tipo + ",");
			bld.append(capacidad + ",");
			for(String medc : medicamentosId) {
				bld.append(medc + ";");
			}
			bld.append(",");
			for(String equip : equiposId) {
				bld.append(equip + ";");
			}
			bld.append(",");
			for(String paci : pacientes) {
				bld.append(paci + ";");
			}
			bld.append("," + idSala);
			Main.escrituraFicheroUltimaLinea("salas.txt", bld.toString(), 0);
		}else {
			throw new ExistePersonal(idSala);
		}		
	}
	
}
