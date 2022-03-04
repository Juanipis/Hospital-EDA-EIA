package hospital;

import java.util.*;

public class Sala {

	// Cambie capacidad de un String a un int y descomente los pacientes. Creo que
	// faltaria un constructor - Chica
	private String tipo;
	private int capacidad;
	private Medicamento medicamentos[];
	private Equipo equipos[];
	private Paciente pacientes[];
	private Enfermero enfermeros[];

	public String getTipo() {
		return tipo;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	// Metodos de busqueda qeu devuelven la posicion-------------------------

	public int verificarPaciente(String cedula) {
		int i = 0;
		while (i < pacientes.length) {
			if (cedula == pacientes[i].getCC()) {
				return i;
			}
		}
		return 0;
	}

	public int verificarEquipo(String codigo) {
		int i = 0;
		while (i < equipos.length) {
			if (codigo == equipos[i].getCodigo()) {
				return i;
			}
		}
		return 0;
	}

	public int verificarMedicamento(String id) {
		int i = 0;
		while (i < medicamentos.length) {
			if (id == medicamentos[i].getId()) {
				return i;
			}
		}
		return 0;
	}
	// Metodos------------------------------------

	public void addPaciente(Paciente paciente, String nombre, String apellido, String cc, String poliza,
			String[] sintomas, int triaje, String[] acompanantes, int edad, String sexo, String tipoSangre,
			Historial historial) {
		// traer cedula de paciente. //Verificarla en un metodo contra un arreglo de
		// pacientes //En caso de que la cedula no exista, agregar el paciente
		if (verificarPaciente(paciente.getCC()) != 0) {
			pacientes = Arrays.copyOf(pacientes, pacientes.length + 1);
			pacientes[pacientes.length - 1] = new Paciente(nombre, apellido, cc, poliza, sintomas, triaje, acompanantes,
					edad, sexo, tipoSangre, historial);
		}
	}
	// agregar exepcion si el equipo ya existe
	public void addEquipo(Equipo equipo, double inventario, boolean disponibilidad, String codigo, boolean estado) {
		if (verificarEquipo(equipo.getCodigo()) != 0) {
			equipos = Arrays.copyOf(equipos, equipos.length + 1);
			equipos[equipos.length - 1] = new Equipo(inventario, disponibilidad, codigo, estado);
		}
	}
	// agregar exepcion si el medicamento ya existe
	public void addMedicamento(Medicamento medicamento, String nombre, String id, Date fechaVencimiento,
			Date fechaCompra, boolean disponibilidad, double cantidad) {
		if (verificarMedicamento(medicamento.getId()) != 0) {
			medicamentos = Arrays.copyOf(medicamentos, medicamentos.length + 1);
			medicamentos[medicamentos.length - 1] = new Medicamento(nombre, id, fechaVencimiento, fechaCompra,
					disponibilidad, cantidad);
		}
	}
	public void eliminarEquipo(String codigoEquipo) {
		int i = 0;
		while (i < equipos.length) {
			if (codigoEquipo == equipos[i].getCodigo()) {
				equipos[i] = equipos[equipos.length - 1];
				equipos = Arrays.copyOf(equipos, equipos.length - 1);
				// returns true porque si existe
			}
		}
	}
	public void eliminarMedicamento(String idMedicamento) {
		int i = 0;
		while (i < medicamentos.length) {
			if (idMedicamento == medicamentos[i].getId()) {
				medicamentos[i] = medicamentos[medicamentos.length - 1];
				medicamentos = Arrays.copyOf(medicamentos, medicamentos.length - 1);
				// returns true porque si existe
			}
		}
	}
}
