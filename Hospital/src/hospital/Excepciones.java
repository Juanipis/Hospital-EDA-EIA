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