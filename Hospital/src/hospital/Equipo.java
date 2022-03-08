package hospital;

public class Equipo {

	private double inventario;
	private boolean disponibilidad;
	private String codigo;
	private boolean estado;

	public Equipo(double inv, boolean disp, String cod, boolean est) {
		inventario = inv;
		disponibilidad = disp;
		codigo = cod;
		estado = est;

	}

	public double getInventario() {
		return inventario;
	}

	public void setInventario(double inventario) {
		this.inventario = inventario;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Estado: " + estado;
	}
}
