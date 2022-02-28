package hospital;

import java.util.Date;

public class Medicamento {

	private String nombre;
	private String id;
	private Date fechaVencimiento;
	private Date fechaCompra;
	private boolean disponibilidad;
	private double cantidad;
	
	public Medicamento(String nombre, String id, Date fechaVencimiento, Date fechaCompra, boolean disponibilidad, double cantidad) {
		this.nombre = nombre;
		this.id = id;
		this.fechaVencimiento = fechaVencimiento;
		this.fechaCompra = fechaCompra;
		this.disponibilidad = disponibilidad;
		this.cantidad = cantidad;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
}
