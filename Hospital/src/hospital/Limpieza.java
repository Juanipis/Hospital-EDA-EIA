package hospital;
import java.util.Arrays;

public class Limpieza extends Personal {

	public Limpieza(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC, disponible);
	}
	
	public void addConserje(String nombre, String apellido, String CC, boolean disponible) throws EPersonal{
		Limpieza[] conserjes = new Limpieza[0];
		for(int i = 0; i < conserjes.length; i++) {
			if(conserjes[i].getCC().equals(CC)) {	
			throw new EPersonal("Esta persona ya se encuentra en el hospital");
		}else {
			conserjes = Arrays.copyOf(conserjes, conserjes.length-1);
			conserjes[conserjes.length-1] = new Limpieza(nombre, apellido, CC, disponible);
		}
	}
}
	
	public void eliminarConserje(String nombre, String apellido, String CC, boolean disponible) {
		Limpieza[] conserjes = new Limpieza[0];
		for(int i = 0; i < conserjes.length; i++) {
			if(conserjes[i].getNombre().equals(nombre)) {
				conserjes[conserjes.length-1] = new Limpieza(nombre, apellido, CC, disponible);
			}
	}
}
	
	public void hacerLimpieza(String CC, String sala) {
		Sala[] salas = new Sala[0];
		for(int i = 0; i < salas.length; i ++) {
			if(salas[i].getLimpia() == false) {
				salas[i].setLimpia(true);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
