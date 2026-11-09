package hospital;

import java.util.ArrayList;
import java.util.Arrays;


public class Formula {
	private String idFormula;
	private ArrayList<String> idMedicamentos; //Contiene tres letras que identifican el medicamento y 1 numero que identifica la cantidad, ejm : ACF4, 4 acetaminofen
	private String incapacidad;
	
	//El id deberia de ser generado automaticamente, por lo tanto no deberia de pedirse como parametro en el constructos - Chica
	//Tengo entendido que la incapacidad se pasa como parametro y se crea con este, pienso que podria ser un boolean - Chica (this.incapacidad = incapacidad)
	public Formula(String idFormula, String[] idMedicamentos, String incapacidad) {
		super();
		this.idFormula = idFormula;
		this.idMedicamentos =  new ArrayList<String>(Arrays.asList(idMedicamentos));
		this.incapacidad = incapacidad;
	}
	public Formula(String idFormula) {
		this.idFormula = idFormula;
		this.idMedicamentos = new ArrayList<>();
		this.incapacidad = "";
	}
	
	public String[] getMedicamentos() {
		return this.idMedicamentos.toArray(new String[idMedicamentos.size()]);
	}
	
	public void addMedicamento(String idMedicamento) throws MedicamentoInvalido{
		if(idMedicamento.length() == 4 && Character.isLetter(idMedicamento.charAt(0)) && Character.isLetter(idMedicamento.charAt(1)) && Character.isLetter(idMedicamento.charAt(2))) {
			this.idMedicamentos.add(idMedicamento);
		}else {
			throw new MedicamentoInvalido(idMedicamento);
		}
		
	}
	
	
	/*
	public void addFormula(String idFormula, String[] idMedicamentos, String incapacidad) {
		Formula[] formula = new Formula[0];
		for(int i = 0; i < formula.length; i++) {
			if(formula[i].getIdFormula().equals(idFormula)) {	
		
			}else {
				formula = Arrays.copyOf(formula, formula.length-1);
				formula[formula.length-1] = new Formula(idFormula, idMedicamentos, incapacidad);
			}
		}
	}
	*/
	public String getIdFormula() {
		return this.idFormula;
	}
	
	@Override
	public String toString() {
		return "Formula [idFormula=" + idFormula + ", idMedicamentos=" + idMedicamentos + ", incapacidad=" + incapacidad
				+ "]";
	}
	public String getIncapacidad() {
		return this.incapacidad;
	}
	
	public void setIncapacidad(String incapacidad) {
		this.incapacidad = incapacidad;
	}
}

class MedicamentoInvalido extends Exception{
	public MedicamentoInvalido(String idMedc) {
		super("El medicamento " +idMedc+ " no tiene el formato correcto, reviselo por favor");
	}
}