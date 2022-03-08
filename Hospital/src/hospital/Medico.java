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
	public int buscarPacienteIndex(String CCPaciente) throws MedicoNoPaciente {
		int index = 0;
		while(index < pacientes.length && pacientes[index]!=null && !pacientes[index].getCC().equals(CCPaciente)) {
			index++;
		}
		if(index < pacientes.length && pacientes[index]!=null && pacientes[index].getCC().equals(CCPaciente)) {
			return index;
		}
		else {
			throw new MedicoNoPaciente(this.getNombre(), CCPaciente);
		}
	}
	public void eliminarPaciente(String CCPaciente) throws MedicoNoPaciente {
		int index = this.buscarPacienteIndex(CCPaciente);
		Paciente[] temp = new Paciente[this.pacientes.length-1];
		int arT = 0;
		int arO = 0;
		
		while(arT < temp.length) {
			if(arT == index) {
				arO++;
			}
			temp[arT] = this.pacientes[arO];
			arT++;
			arO++;
		}
		this.pacientes = temp;	
	}
	public Paciente[] getPacientes() {
		return pacientes;
	}
	
	public void setPrescripciones(boolean pres) {
		this.pres = pres;
	}
	
	public String toString() {
		return (this.getNombre() + " : " + this.getApellido() + " : " + this.getCC() + " : " + this.getDisponible() + " : " + this.getEsp() + " : " + this.getPres() + "\n");
	}
	
	//Le pasamos la formula al medico para que la pueda editar
	public void addFormula(Formula fl, String[] idMedicamentos, String incapacidad) throws EMedicamento, MedicamentoInvalido {
		fl.setIncapacidad(incapacidad);
		for(String medc : idMedicamentos) {
			fl.addMedicamento(medc);
		}
	}
	//El historial se genera desde una cita
	/*
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
	}*/
}
