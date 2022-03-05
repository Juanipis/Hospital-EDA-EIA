package hospital;

import java.util.Arrays;

public class Medico extends Personal {

	private String esp;
	private boolean pres;
	private Paciente[] pacientes = new Paciente[0];

	public Medico(String nombre, String apellido, String CC, boolean disponible, String esp, boolean pres) {
		super(nombre, apellido, CC, disponible);
		this.esp = esp;
		this.pres = pres;
	}
	
	public void addPaciente(Paciente pc) {
		//Verificar que el paciente no se repita
		pacientes = Arrays.copyOf(pacientes, pacientes.length+1);
		pacientes[pacientes.length-1] = pc;
	}
	
	public boolean getPres() {
		return this.pres;
	}
	public String getEsp() {
		return this.esp;
	}
	
	public Paciente[] getPacientes() {
		return pacientes;
	}
	
	public void setPrescripciones(boolean pres) {
		this.pres = pres;
	}
	
	
	public void addFormula(String idFormula, String[] idMedicamentos, String incapacidad) throws EMedicamento {
		Formula[] formula = new Formula[0];
		for(int i = 0; i < formula.length; i++) {
			if(formula[i].getIdFormula().equals(idFormula)) {	
				throw new EMedicamento("Este medicamento ya se encuentra en el hospital");
			}else {
				formula = Arrays.copyOf(formula, formula.length-1);
				formula[formula.length-1] = new Formula(/*idFormula,*/ idMedicamentos, incapacidad);
			}
		}
	}

	public void addHistorial(String[] enfermedades, String[] operaciones, String[] alergias, String citaId) throws ExistePersonal{
		//Cambie un parametro de Cita cita -> String citaId para poder satisfacer el constructor y un condicional -Rafael
		Historial[] historial = new Historial[0];
		for(int i = 0; i < historial.length; i++) {
			if(historial[i].getIdCita().equals(citaId)) {	
				//corregi un error de .getCita().equals(cita) -> .getIdCita().equals(cita)) -Rafael
				throw new ExistePersonal(CC);
			}else {
				historial = Arrays.copyOf(historial, historial.length+1);
				historial[historial.length-1] = new Historial(enfermedades, operaciones, alergias, citaId);
			}
		}
	}
}
