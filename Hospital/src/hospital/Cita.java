package hospital;

import java.util.*;

public class Cita {
	private String CCPaciente;
	private String CCMedico;
	private Date fechaInicio;
	private Date fechaFinal;
	private Formula formula;
	private String idCita;

	// Si se le va a asignar una formula desde la creacion de la cita, tambien hay
	// que pasarle los parametros necesarios para crearla desde el constructor
	// pero como creo que se va a asignar despues de la cita, no deberia de estar en
	// el constructor, si no que se le agrega despues con un set - Chica
	public Cita(String cCPaciente, String cCMedico, Date fechaInicio, Date fechaFinal, String idCita) {
		super();
		this.CCPaciente = cCPaciente;
		this.CCMedico = cCMedico;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		//this.formula = new Formula();
		this.idCita = idCita;
	}

	public void addFormulaMedicamentos(String[] medicamentos) throws MedicamentoInvalido {
		try {
			for (String med : medicamentos) {
				formula.addMedicamento(med);
			}
		} catch (MedicamentoInvalido e) {
			throw e;
		}
	}

	// Pinso que es mas facil trabajar la incapacidad como un boolean - Chica
	public void setFormulaIncapacidad(String incapacidad) {
		formula.setIncapacidad(incapacidad);
	}
	public void setFormula( String[] idMedicamentos, String incapacidad) {
		formula = new Formula(idMedicamentos, incapacidad);
	}

	public String getCCPaciente() {
		return CCPaciente;
	}

	public void setCCPaciente(String cCPaciente) {
		CCPaciente = cCPaciente;
	}

	public String getCCMedico() {
		return CCMedico;
	}

	public void setCCMedico(String cCMedico) {
		CCMedico = cCMedico;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Formula getFormula() {
		return formula;
	}

	public String getIdCita() {
		return idCita;
	}

	@Override
	public String toString() {
		return "Cita [CCPaciente=" + CCPaciente + ", CCMedico=" + CCMedico + ", fechaInicio=" + fechaInicio
				+ ", fechaFinal=" + fechaFinal + ", idCita=" + idCita + "]\n";
	}

}
