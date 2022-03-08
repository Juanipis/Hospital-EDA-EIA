package hospital;

public class Excepciones {

}

class FormatoFechaInvalida extends Exception{
	public FormatoFechaInvalida() {
		super("Las fechas o fecha entregada tienen un formato incorrecto o no son congruentes entre si");
	}
}
class CitaNoExiste extends Exception{
	public CitaNoExiste(String idCita) {
		super("La cita"+ idCita +" no existe");
	}
}
class PersonaNoCitas extends Exception{
	public PersonaNoCitas(String nombreP) {
		super("La persona " + nombreP + " no tiene citas");
	}
}
class NoHayDisponibilidadCita extends Exception{
	public NoHayDisponibilidadCita() {
		super("No hay disponibilidad para la cita ingresada, intente otras fechas");
	}
}
class MedicoNoCitas extends Exception{
	public MedicoNoCitas(String CC) {
		super("El medico con la " + CC +" no tiene citas");
	}
}

class ExistePersonal extends Exception {
	public ExistePersonal(String CC) {
		super("Esta " + CC+ " persona ya se encuentra en el hospital");
	}
}

class NoExistePersonal extends Exception {
	public NoExistePersonal(String CC) {
		super("Esta " + CC+ " persona no existe en el hospital");
	}
}
class EMedicamento extends Exception{
	public EMedicamento(String info) {
		super(info);
	}
}
class NoExisteSala extends Exception{
	public NoExisteSala(String sala) {
		super("La sala: " + sala + " no existe");
	}
}
class SalaLimpia extends Exception{
	public SalaLimpia(String idSala) {
		super("La sala: " + idSala + "Esta sala ya se encuentra limpia");
	}
}
class PacienteEnSala extends Exception{
	public PacienteEnSala(String CC) {
		super("El paciente con la cedula" + CC + " ya se encuentra en la sala");
	}
}
class NoPacienteEnSala extends Exception{
	public NoPacienteEnSala(String CC) {
		super("El paciente con la cedula" + CC + " no se encuentra en la sala");
	}
}
class NoPacienteEnNingunaSala extends Exception{
	public NoPacienteEnNingunaSala(String cc) {
		super("El paciente: " + cc + " no se enuentra en ninguna sala");
	}
}
class NoAcompanantesPaciente extends Exception{
	public NoAcompanantesPaciente() {
		super("No existe el acompañante de la persona");
	}
}
class EnfermeroEnSala extends Exception {
	public EnfermeroEnSala(String CC) {
		super("Enfermero con la cedula: "+CC+" ya se encuentra en la sala");
	}
}
class EquipoEnSala extends Exception {
	public EquipoEnSala(String codigoEquipo) {
		super("El equipo con el codigo: "+codigoEquipo+" ya se encuentra en la sala");
	}
}
class MedicamentoEnSala extends Exception {
	public MedicamentoEnSala(String idMedicamento) {
		super("El medicamento con el id: "+idMedicamento+" ya se encuentra en la sala");
	}
}
class FechaInvalida extends Exception{
	public FechaInvalida() {
		super("La fecha ingresada tiene un formato incorrecto");
	}
}

class MedicoNoPaciente extends Exception{
	public MedicoNoPaciente(String nombreMedico, String CCPaciente) {
		super("El medico " +  nombreMedico + " no tiene el paciente con la cedula " + CCPaciente);
	}
}
class SalaLLena extends Exception{
	public SalaLLena(String idSala) {
		super("La sala " + idSala + " está llena");
	}
}

class NoExistePaciente extends Exception{
	public NoExistePaciente(String CCPaciente) {
		super("El paciente con la cedula " + CCPaciente + " no existe");
	}
}
class NoSeEncuetraMedico extends Exception {
	public NoSeEncuetraMedico() {
		super ("No se encuentra medico");
	}
}

class CampoLleno extends Exception{
	public CampoLleno() {
		super("No se pueden agregar mas");
	}
}
class NoEquipoEnSala extends Exception{
	public NoEquipoEnSala() {
		super("El equipo no se encuentra en la sala");
	}
}

class NoMedicamentoEnSala extends Exception{
	public NoMedicamentoEnSala() {
		super("El medicamento no se encuentra en la sala");
	}
}

class NoEnfermeroEnSala extends Exception{
	public NoEnfermeroEnSala() {
		super("El enfermero no se encuentra en la sala");
	}
}
class campoNulo extends Exception{
	public campoNulo() {
		super("Revisa los campos, algunos pueden estar nulos");
	}
}
