package hospital;

import java.util.Date;

public class Cita {
	private String CCPaciente;
	private String CCMedico;
	private Date fechaInicio;
	private Date fechaFinal;
	private Formula formula;
	
	public Cita(String cCPaciente, String cCMedico, Date fechaInicio, Date fechaFinal) {
		super();
		this.CCPaciente = cCPaciente;
		this.CCMedico = cCMedico;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.formula = new Formula();
	}
	
	public void addFormulaMedicamentos(String[] medicamentos) throws MedicamentoInvalido {
		try {
			for(String med : medicamentos) {
				formula.addMedicamento(med);
			}
		} catch (MedicamentoInvalido e) {
			throw e;
		}
	}
	
	public void setFormulaIncapacidad(String incapacidad) {
		formula.setIncapacidad(incapacidad);
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
	
	
	
}
