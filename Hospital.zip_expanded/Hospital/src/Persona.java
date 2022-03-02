
public abstract class Persona {

	protected String nombre;
	protected String apellido;
	protected String CC;
	
	
	public Persona(String nombre, String apellido, String CC) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.CC = CC;
	}

	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getCC() {
		return CC;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
