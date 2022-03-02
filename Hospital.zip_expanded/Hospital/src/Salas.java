
public class Salas extends Personal{
	
	String tipo;
	int capacidad;
	boolean limpia;
	
	public Salas(String nombre, String apellido, String CC, boolean disponible, String tipo, int capacidad, boolean limpia) {
		super(nombre, apellido, CC, disponible);
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.limpia = limpia;
	}

	public String getTipo() {
		return tipo;
	}
	
	public int getCapacidad() {
		return capacidad;
	}
	
	public boolean getLimpia() {
		return limpia;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void setLimpia(boolean limpia) {
		this.limpia = limpia;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
