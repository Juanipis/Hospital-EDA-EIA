package hospital;

public class Bebe extends Paciente{
	private String[] padres = new String [2];

	public Bebe(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje,
				String[] acompaņantes, int edad, String sexo, String tipoSangre, Historial historial, String[] padres) {
		super(nombre, apellido, cc, poliza, sintomas, triaje, acompaņantes, edad, sexo, tipoSangre, historial);
		this.padres = padres;
	}

}
