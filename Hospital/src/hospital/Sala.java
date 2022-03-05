package hospital;

import java.util.Arrays;
import java.util.Date;

public class Sala {

	//Cambie capacidad de un String a un int y descomente los pacientes. Creo que faltaria un constructor - Chica
	
	private String tipo;
	private int capacidad;
	private String medicamentosId[];
	private String equiposId[];
	private String pacientes[];
	private String idSala;
	// private Enfermo enfermos[];

//	public boolean verificarPaciente(String cedula) { int i = 0; while( i <
//	  pacientes.length) { if(cedula == pacientes[i].getCedula()) { return true;
//	  //returns true porque si existe } } return false; //returns false porque no existe } // agregar exepcion si el paciente ya existe public void
//
//	addPaciente(Paciente paciente) { //traer cedula de paciente. //Verificarla en un metodo contra un arreglo de pacientes //En caso de que la cedula no exista, agregar el paciente
//	  
//	  
//	  }


	public boolean verificarEquipo(String codigo) {
		int i = 0;
		while (i < equipos.length) {
			if (codigo == equipos[i].getCodigo()) {
				return true;
				// returns true porque si existe
			}
		}
		return false;
		// returns false porque no existe
	}
	
	public Sala(String tipo, int capacidad, String[] medicamentosId, String[] equiposId, String[] pacientes,String idSala) {
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.medicamentosId = medicamentosId;
		this.equiposId = equiposId;
		this.pacientes = pacientes;
		this.idSala = idSala;
	}

	public String getIdSala() {
		return idSala;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	// agregar exepcion si el equipo ya existe
	public void addEquipo(Equipo equipo, double inventario, boolean disponibilidad, String codigo, boolean estado) {
		if (verificarEquipo(equipo.getCodigo()) == false) {
			equipos = Arrays.copyOf(equipos, equipos.length + 1);
			equipos[equipos.length - 1] = new Equipo(inventario, disponibilidad, codigo, estado);

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

	public boolean verificarMedicamento(String id) {
		int i = 0;
		while (i < medicamentos.length) {
			if (id == medicamentos[i].getId()) {
				return true;
				// returns true porque si existe
			}
		}
		return false;
		// returns false porque no existe
	}

	// agregar exepcion si el medicamento ya existe
	public void addMedicamento(Medicamento medicamento, String nombre, String id, Date fechaVencimiento,
			Date fechaCompra, boolean disponibilidad, double cantidad) {
		if (verificarMedicamento(medicamento.getId()) == false) {
			medicamentos = Arrays.copyOf(medicamentos, medicamentos.length + 1);
			medicamentos[medicamentos.length - 1] = new Medicamento(nombre, id, fechaVencimiento, fechaCompra,
					disponibilidad, cantidad);

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
