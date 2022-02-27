package hospital;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hospital {
	private AgendaHospital agendaHospital = new AgendaHospital();
	
	
	public boolean generarCita(String CCPaciente, String CCMedico,int[] fechaInicio, int[] fechaFinal) {
		try {
			this.agendaHospital.generarCita(CCPaciente, CCMedico, fechaInicio, fechaFinal);
			return true;
		} catch (FormatoFechaInvalida | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return false;
	}
	public boolean modificarCita(String idCita, int[] fechaInicio, int[] fechaFinal) throws FormatoFechaInvalida{
		if(fechaInicio.length == 5 && fechaFinal.length ==4) {
			Calendar fi = new GregorianCalendar(fechaInicio[0], fechaInicio[1], fechaInicio[2], fechaInicio[3], fechaInicio[4]);
			Calendar ff = new GregorianCalendar(fechaFinal[0], fechaFinal[1], fechaFinal[2], fechaFinal[3], fechaFinal[4]);
			try {
				this.agendaHospital.modificarCita(idCita, fi.getTime(), ff.getTime());
				return true;
			} catch (FormatoFechaInvalida e) {
				throw new FormatoFechaInvalida();
				return false;
			}
		}else {
			throw new FormatoFechaInvalida();
			return false;
		}
	}
	
	public boolean cancelarCita(String idCita) {
		try {
			this.agendaHospital.cancelarCita(idCita);
			return true;
		} catch (CitaNoExiste e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return false;
	}
	
	public Cita buscarCita(String idFormula) {
		
	}
}
