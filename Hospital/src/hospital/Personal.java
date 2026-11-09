package hospital;

public abstract class Personal extends Persona{

	
	
	protected boolean disponible;
	
	public Personal(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC);
		this.disponible = disponible;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
