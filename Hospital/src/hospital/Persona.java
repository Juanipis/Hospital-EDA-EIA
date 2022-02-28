package hospital;

public abstract class Persona {
	protected String nombre;
	protected String apellido;
	protected String CC;
	
	public Persona(String nombre, String apellido, String cC) {
		this.nombre = nombre;
		this.apellido = apellido;
		CC = cC;
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
	
}
