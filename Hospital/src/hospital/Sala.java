package hospital;

import java.util.*;

class VectorNulo extends Exception {
	public VectorNulo() {
		super("No");
	}
}

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

	// Metodos de busqueda que devuelven la posicion-------------------------

	public int verificarPaciente(String cedula) throws VectorNulo {
		if (pacientes == null) {
			throw new VectorNulo();
		} else {
			int i = 0;
			while (i < pacientes.length) {
				if (cedula == pacientes[i].getCC()) {
					return i;
				}
			}
			return -1;
		}
	}

	public int verificarEquipo(String codigo) throws VectorNulo {
		if (equipos == null) {
			throw new VectorNulo();
		} else {

			int i = 0;
			while (i < equipos.length) {
				if (codigo == equipos[i].getCodigo()) {
					return i;
				}
			}
			return -1;
		}

	}

	public int verificarMedicamento(String id) throws VectorNulo {
		if (medicamentos == null) {
			throw new VectorNulo();
		} else {
			int i = 0;
			while (i < medicamentos.length) {
				if (id == medicamentos[i].getId()) {
					return i;
				}
			}
			return -1;
		}

	}

	public int verificarEnfermero(String cedula) throws VectorNulo {
		if (enfermeros == null) {
			throw new VectorNulo();
		} else {
			int i = 0;
			while (i < enfermeros.length) {
				if (cedula == enfermeros[i].getCC()) {
					return i;
				}
			}
			return -1;
		}

	}
	// Metodos------------------------------------

	public void addPaciente(Paciente paciente, String nombre, String apellido, String cc, String poliza,
			String[] sintomas, int triaje, String[] acompanantes, int edad, String sexo, String tipoSangre,
			Historial historial) {
		// traer cedula de paciente. //Verificarla en un metodo contra un arreglo de
		// pacientes //En caso de que la cedula no exista, agregar el paciente
		try {
			if (verificarPaciente(paciente.getCC()) != -1) {
				pacientes = Arrays.copyOf(pacientes, pacientes.length + 1);
				pacientes[pacientes.length - 1] = new Paciente(nombre, apellido, cc, poliza, sintomas, triaje,
						acompanantes, edad, sexo, tipoSangre, historial);
			}
		} catch (VectorNulo e) {
			// Momentaneo, luego cambiar para imprimir en ventana Porras
			System.out.println(e.getMessage());
		}
	}

	public void addEquipo(double inventario, boolean disponibilidad, String codigo, boolean estado) {
		try {
			if (verificarEquipo(codigo) != -1) {
				equipos = Arrays.copyOf(equipos, equipos.length + 1);
				equipos[equipos.length - 1] = new Equipo(inventario, disponibilidad, codigo, estado);
			}
		} catch (VectorNulo e) {
			// Momentaneo, luego cambiar para imprimir en ventana Porras
			System.out.println(e.getMessage());
		}
	}

	public void addMedicamento(String nombre, String id, Date fechaVencimiento, Date fechaCompra,
			boolean disponibilidad, double cantidad) {
		try {
			if (verificarMedicamento(id) != -1) {
				medicamentos = Arrays.copyOf(medicamentos, medicamentos.length + 1);
				medicamentos[medicamentos.length - 1] = new Medicamento(nombre, id, fechaVencimiento, fechaCompra,
						disponibilidad, cantidad);
			}
		} catch (VectorNulo e) {
			// Momentaneo, luego cambiar para imprimir en ventana Porras
			System.out.println(e.getMessage());
		}
	}
	// Mertodos eliminacion--------------------------------------

	public void eliminarEquipo(String codigoEquipo) throws VectorNulo {
		if (verificarEquipo(codigoEquipo) != -1)
			for (int i = verificarEquipo(codigoEquipo); i < equipos.length; i++) {
				if (equipos[i + 1] != null)
					equipos[i] = equipos[i + 1];
				if (i == equipos.length - 1)
					equipos = Arrays.copyOf(equipos, equipos.length - 1);
			}
	}

	public void eliminarMedicamento(String idMedicamento) throws VectorNulo {
		if (verificarMedicamento(idMedicamento) != -1)
			for (int i = verificarMedicamento(idMedicamento); i < equipos.length; i++) {
				if (medicamentos[i + 1] != null)
					medicamentos[i] = medicamentos[i + 1];
				if (i == medicamentos.length - 1)
					medicamentos = Arrays.copyOf(medicamentos, medicamentos.length - 1);
			}
	}

	public void eliminarEnfermero(String cedula) throws VectorNulo {
		if (verificarEnfermero(cedula) != -1)
			for (int i = verificarEnfermero(cedula); i < equipos.length; i++) {
				if (enfermeros[i + 1] != null)
					enfermeros[i] = enfermeros[i + 1];
				if (i == enfermeros.length - 1)
					enfermeros = Arrays.copyOf(enfermeros, enfermeros.length - 1);
			}
	}
}
