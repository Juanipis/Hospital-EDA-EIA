package hospital;

import java.util.ArrayList;
import java.util.UUID;

public class Formula {
	private String idFormula;
	private ArrayList<String> idMedicamentos; //Contiene tres letras que identifican el medicamento y 1 numero que identifica la cantidad, ejm : ACF4, 4 acetaminofen
	private String incapacidad;
	
	
	public Formula() {
		super();
		this.idFormula = UUID.randomUUID().toString();
		this.idMedicamentos =  new ArrayList<String>();
		this.incapacidad = "";
	}
	
	public String[] getMedicamentos() {
		return this.idMedicamentos.toArray(new String[0]);
	}
	
	public void addMedicamento(String idMedicamento) throws MedicamentoInvalido{
		if(idMedicamento.length() == 4 && Character.isLetter(idMedicamento.charAt(0)) && Character.isLetter(idMedicamento.charAt(1)) && Character.isLetter(idMedicamento.charAt(2))) {
			this.idMedicamentos.add(idMedicamento);
		}else {
			throw new MedicamentoInvalido(idMedicamento);
		}
		
	}
	
	public String getIdFormula() {
		return this.idFormula;
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