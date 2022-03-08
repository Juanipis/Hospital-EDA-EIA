package hospital;

public class Limpieza extends Personal {

	public Limpieza(String nombre, String apellido, String CC, boolean disponible) {
		super(nombre, apellido, CC, disponible);
	}
	
	
	public void hacerLimpieza(Sala sala) throws SalaLimpia {
		if (sala.getLimpia() == false) {
			sala.setLimpia(true);
		}else {
			throw new SalaLimpia(sala.getTipo());
		}
	}


	@Override
	public String toString() {
		return "Nombre: " + nombre + ", Apellido: " + apellido + ", CC: " + CC
				+ ", Disponible: " + disponible;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
		
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
		
	}
	
}
