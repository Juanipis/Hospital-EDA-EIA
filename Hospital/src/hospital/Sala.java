package hospital;

import java.io.IOException;
import java.util.*;

class VectorNulo extends Exception {
	public VectorNulo() {
		super("No");
	}
}

public class Sala {

	//Cambie capacidad de un String a un int y descomente los pacientes. Creo que faltaria un constructor - Chica
	
	private String tipo;
	private int capacidad;
	private Medicamento medicamentos[];
	private Equipo equipos[];
	private Paciente pacientes[];
	private Enfermero enfermeros[];
	
	//Aqui voy a introducir una nueva variable para sala, este va a ser un boolean limpia. CAPITAN RECORDAR AGREGARLO AL FICHERO! Tambien se creo el metodo getLimpia y setLimpia.
	private boolean limpia;
	
	// private Enfermo enfermos[];

	
	
	public Sala(String tipo, int capacidad, Medicamento[] medicamentos, Equipo[] equipos, Paciente[] pacientes,
			Enfermero[] enfermeros, boolean limpio) {
		super();
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.medicamentos = medicamentos;
		this.equipos = equipos;
		this.pacientes = pacientes;
		this.enfermeros = enfermeros;
		this.limpia = limpio;
	}


	public String getTipo() {
		return tipo;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public boolean getLimpia() {
		return limpia;
	}
	
	public void setLimpia(boolean limpia) {
		this.limpia = limpia;
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

	public void addPaciente(String nombre, String apellido, String cc, String poliza, String[] sintomas, int triaje, String[] acompanantes,
			int edad, String sexo, String tipoSangre) throws IOException,VectorNulo {
		// traer cedula de paciente. //Verificarla en un metodo contra un arreglo de
		// pacientes //En caso de que la cedula no exista, agregar el paciente
		
			if (verificarPaciente(cc) != -1) {
				pacientes = Arrays.copyOf(pacientes, pacientes.length + 1);
				pacientes[pacientes.length - 1] = new Paciente(nombre, apellido, cc, poliza, sintomas, triaje,
						acompanantes, edad, sexo, tipoSangre);
			}else {
				System.out.println("No se puede agregar paciente porque ya existe un paciente con esa cedula");
			}
		
	}
	public void addPaciente(Paciente pc) throws IOException,VectorNulo, PacienteEnSala {
		// traer cedula de paciente. //Verificarla en un metodo contra un arreglo de
		// pacientes //En caso de que la cedula no exista, agregar el paciente
		
			if (verificarPaciente(pc.getCC()) != -1) {
				pacientes = Arrays.copyOf(pacientes, pacientes.length + 1);
				pacientes[pacientes.length - 1] = pc;
			}else {
				throw new PacienteEnSala(pc.getCC());
			}
		
	}
	public void addEnfermero(String nombre, String apellido, String CC, boolean disponible) throws VectorNulo {
		if (verificarEnfermero(CC) != -1) {
			enfermeros = Arrays.copyOf(enfermeros, enfermeros.length + 1);
			enfermeros[enfermeros.length - 1] = new Enfermero(nombre, apellido, CC, disponible);
		}else {
			System.out.println("No se puede agregar Enfermero porque ya existe un Enfermero con esa cedula, en la sala");
		}
	}

	public void addEquipo(double inventario, boolean disponibilidad, String codigo, boolean estado) throws VectorNulo{
		
			if (verificarEquipo(codigo) != -1) {
				equipos = Arrays.copyOf(equipos, equipos.length + 1);
				equipos[equipos.length - 1] = new Equipo(inventario, disponibilidad, codigo, estado);
			
		} else {
			System.out.println("No se puede agregar equipo porque ya existe un equipo con ese codigo");
		} 
			
		
	}

	public void addMedicamento(String nombre, String id, Date fechaVencimiento, Date fechaCompra,
			boolean disponibilidad, double cantidad) throws VectorNulo {

			if (verificarMedicamento(id) != -1) {
				medicamentos = Arrays.copyOf(medicamentos, medicamentos.length + 1);
				medicamentos[medicamentos.length - 1] = new Medicamento(nombre, id, fechaVencimiento, fechaCompra,
						disponibilidad, cantidad);
			}else {
				System.out.println("No se puede agregar medicamento porque ya existe un medicamento con ese id");
			} 
	}
	// Metodos de eliminacion--------------------------------------

	
	public void eliminarPaciente(String cedula) throws VectorNulo{
		if(verificarPaciente(cedula) != -1) {
			for(int i = verificarPaciente(cedula); i<pacientes.length ; i++) {
				if(pacientes[i + 1] != null) {
					pacientes[i] = pacientes[i+1];
				}
				if(i == pacientes.length-1) {
					pacientes = Arrays.copyOf(pacientes, pacientes.length-1);
				}
			}
		}else {
			System.out.println("No existe un Paciente con esa cedula");
		}
	}
	public void eliminarEquipo(String codigoEquipo) throws VectorNulo {
		if (verificarEquipo(codigoEquipo) != -1) {
			for (int i = verificarEquipo(codigoEquipo); i < equipos.length; i++) {
				if (equipos[i + 1] != null)
					equipos[i] = equipos[i + 1];
				if (i == equipos.length - 1)
					equipos = Arrays.copyOf(equipos, equipos.length - 1);
			}
		}else {
			//Mirar si esta bien hecho devovler el texto desde el mismo metodo, ya que no es una excepcion. Es una condicion del sistema
			System.out.println("No existe un Equipo con ese codigo");
		}
	}

	public void eliminarMedicamento(String idMedicamento) throws VectorNulo {
		if (verificarMedicamento(idMedicamento) != -1) {
			for (int i = verificarMedicamento(idMedicamento); i < equipos.length; i++) {
				if (medicamentos[i + 1] != null)
					medicamentos[i] = medicamentos[i + 1];
				if (i == medicamentos.length - 1)
					medicamentos = Arrays.copyOf(medicamentos, medicamentos.length - 1);
			}
		}else {
		//Mirar si esta bien hecho devovler el texto desde el mismo metodo, ya que no es una excepcion. Es una condicion del sistema
		System.out.println("No existe un Medicamento con ese id");
		}
	}

	public void eliminarEnfermero(String cedula) throws VectorNulo {
		if (verificarEnfermero(cedula) != -1) {
			for (int i = verificarEnfermero(cedula); i < equipos.length; i++) {
				if (enfermeros[i + 1] != null)
					enfermeros[i] = enfermeros[i + 1];
				if (i == enfermeros.length - 1)
					enfermeros = Arrays.copyOf(enfermeros, enfermeros.length - 1);
			}
		}else {
				//Mirar si esta bien hecho devovler el texto desde el mismo metodo, ya que no es una excepcion. Es una condicion del sistema
				System.out.println("No existe un Enfermero con esa cedula");
			}
	}
	
	public boolean getDisponibilidadSala() {
		return (this.capacidad-this.pacientes.length > 0) ? true:false;
	}
	
	@Override
	public String toString() {
		return "Sala [tipo=" + tipo + ", capacidad=" + capacidad + ", medicamentos=" + Arrays.toString(medicamentos)
				+ ", equipos=" + Arrays.toString(equipos) + ", pacientes=" + Arrays.toString(pacientes)
				+ ", enfermeros=" + Arrays.toString(enfermeros) + ", limpia=" + limpia + "]";
	}
}
