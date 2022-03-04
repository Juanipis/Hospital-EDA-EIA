package hospital;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hospital {
	private AgendaHospital agendaHospital;
	private Paciente pacientes[];
	
	public Hospital() throws IOException {
		this.agendaHospital = new AgendaHospital();
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
	
	//Metodos relacionados con pacientes
	public void addPaciente(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje, String[] acompanantes,
							int edad, String sexo, String tipoSangre) {
		if(buscarPaciente(cc) == null) {
			//throw new EEXceptionValorInvalido()
		}else {
			Paciente p = new Paciente(nombre, apellido, cc, poliza, sintomas, triaje, acompanantes, edad, sexo, tipoSangre);
			pacientes = Arrays.copyOf(pacientes, pacientes.length + 1);
			pacientes[pacientes.length-1] = p;
		}
	}
	
	public Paciente buscarPaciente(String cc){ //throws EExceptionInexistente, EExceptionValorInvalido
		int indice = 0;
		if(cc == null || cc.length() == 0) {
			//throw new EExceptionValorInvalido();
		}else {
			while(indice < pacientes.length && pacientes[indice].getCC().equals(cc) != true) {
				indice++;
			}
		}
		return(indice < pacientes.length)? pacientes[indice] : null;
	}
	
	public void eliminarPaciente(String cc) {
		
	}
	
	
}
