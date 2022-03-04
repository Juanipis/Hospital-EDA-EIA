package hospital;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Medico extends Personal{

	String esp;
	boolean pres;
	Paciente[] pacientes = new Paciente[0];
	
	public Medico(String nombre, String apellido, String CC, boolean disponible, String esp, boolean pres) {
		super(nombre, apellido, CC, disponible);
		this.esp = esp;
		this.pres = pres;
	}
	
	
	
	public void setPrescripciones(boolean pres) {
		this.pres = pres;
	}
	
	public void addFormula(String idFormula, String[] idMedicamentos, String incapacidad) throws EPersonal {
		Formula[] formula = new Formula[0];
		for(int i = 0; i < formula.length; i++) {
			if(formula[i].getIdFormula().equals(idFormula)) {	
				throw new EPersonal("Este medicamento ya se encuentra en el hospital");
			}else {
				formula = Arrays.copyOf(formula, formula.length-1);
				formula[formula.length-1] = new Formula(idFormula, idMedicamentos, incapacidad);
			}
		}
	}

	public void addHistorial(String[] enfermedades, String[] operaciones, String[] alergias, Cita cita) throws EPersonal{
		Historial[] historial = new Historial[0];
		for(int i = 0; i < historial.length; i++) {
			if(historial[i].getCita().equals(cita)) {	
				throw new EPersonal("El historial de este paciente ya esta registrado");
			}else {
				historial = Arrays.copyOf(historial, historial.length-1);
				historial[historial.length-1] = new Historial(enfermedades, operaciones, alergias, cita);
			}
		}
	}
}
