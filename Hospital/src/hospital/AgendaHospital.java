package hospital;

import java.util.Date;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

//Comentarios importantes
// 27-02-22 Se ordenó las listas de los pacientes y medicos de tal manera que fuera posible encotrar huecos, lo que facilita el metodo disponibilidad extremos, cambiarlo

public class AgendaHospital {
	private ArrayList<Cita> citas = new ArrayList<Cita>();
	private File agendaCitas = new File("cita.txt");

	public AgendaHospital() throws IOException {
		super();
		//Recuperar todas las citas
		this.recuperarCitas();
	}
	
	private void recuperarCitas() throws IOException {
		BufferedReader fichero = new BufferedReader(new FileReader(agendaCitas));
		String citaAct;
		while( ( citaAct = fichero.readLine()) != null) {
			String[] partesCita = citaAct.split(",");
			if(partesCita.length == 13) {
				Calendar fi = new GregorianCalendar(
							Integer.parseInt(partesCita[2]), 
			        		Integer.parseInt(partesCita[3]),
			        		Integer.parseInt(partesCita[4]),
			        		Integer.parseInt(partesCita[5]),
			        		Integer.parseInt(partesCita[6]));
				Calendar ff = new GregorianCalendar(
			        		Integer.parseInt(partesCita[7]), 
			        		Integer.parseInt(partesCita[8]),
			        		Integer.parseInt(partesCita[9]),
			        		Integer.parseInt(partesCita[10]),
			        		Integer.parseInt(partesCita[11]));
				citas.add(new Cita(partesCita[0], partesCita[1], fi.getTime(), ff.getTime(), partesCita[12]));
		        }
		        
			}
			 fichero.close();
		} 
	
	
	private void generarCitaFichero(String datos) throws IOException {
		FileWriter fichero = new FileWriter(agendaCitas.getAbsoluteFile(), true);
		fichero.write(datos + "\n");
		fichero.close();
	}
	
	private void eliminarCitaFichero(String idCita) {
		File inputFile = new File("cita.txt");
        File tempFile = new File("citaTemp.txt");
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (currentLine.contains(idCita)) {
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            reader.close();
            inputFile.delete();
            tempFile.renameTo(inputFile);
        } catch (Exception e){
        	System.out.println(e.getMessage());
        }
	}
	
	private void editarCitaFicero(String idCita, String CCPaciente ,String CCMedico, Calendar fi, Calendar ff) throws IOException {
		File inputFile = new File("cita.txt");
        File tempFile = new File("citaTemp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
        	if (currentLine.contains(idCita)) {
        		StringBuilder modf = new StringBuilder();
        		modf.append(CCPaciente+",");
        		modf.append(CCMedico+",");
        		modf.append(fi.get(1) +","+fi.get(2) + "," + fi.get(5) + "," +fi.get(11) + "," +fi.get(12) + ",");
        		modf.append(ff.get(1) +","+ff.get(2) + "," + ff.get(5) + "," +ff.get(11) + "," +ff.get(12) + ",");
        		modf.append(idCita);
        		writer.write(modf.toString() + System.getProperty("line.separator"));
        		continue;
        	}
        	writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
	}
	
	public boolean generarCita(String CCPaciente, String CCMedico, int [] fechaInicio, int [] fechaFinal ) throws FormatoFechaInvalida, IOException, NoHayDisponibilidadCita {
		// Es necesario comprobar si el medico y el paciente existen en el hospital y devolver un true or false
		// int[] fechaI :  int Iano, int Imes, int dia, int Ihora, int Iminuto
		// Es neceario comprobar ademas que la fecha a agregar no tenga conflicto con las fechas del medico
		if(fechaInicio.length == 5 && fechaFinal.length == 5) {
			Calendar fi = new GregorianCalendar(fechaInicio[0], fechaInicio[1], fechaInicio[2], fechaInicio[3], fechaInicio[4]);
			Calendar ff = new GregorianCalendar(fechaFinal[0], fechaFinal[1], fechaFinal[2], fechaFinal[3], fechaFinal[4]);
			
			String idCita = UUID.randomUUID().toString();
			//Para añadir al fichero
			StringBuilder cita = new StringBuilder();
			cita.append(CCPaciente + ",");
			cita.append(CCMedico + ",");
			
			for(int flI : fechaInicio) {
				cita.append(flI + ",");
			}
			for (int i = 0; i < fechaFinal.length; i++) {
				cita.append(fechaFinal[i] + ",");	
			}
			cita.append(idCita);
			
			try {
				if(this.disponibilidadCita(CCMedico, fi.getTime(), ff.getTime())) {
					this.generarCitaFichero(cita.toString()); //Se añade al fichero
					citas.add(new Cita(CCPaciente, CCMedico, fi.getTime(), ff.getTime(), idCita));
					return true;
				}else {
					throw new NoHayDisponibilidadCita();
				}
			} catch (IOException e) {
				throw e;
			} catch (MedicoNoCitas e) {
				this.generarCitaFichero(cita.toString()); //Se añade al fichero
				citas.add(new Cita(CCPaciente, CCMedico, fi.getTime(), ff.getTime(), idCita));
				return true;
			} catch (FormatoFechaInvalida e) {
				throw new FormatoFechaInvalida();
			}
		}else {
			throw new FormatoFechaInvalida();
		}
	}
	
	
	
	public void cancelarCita(String idCita) throws CitaNoExiste{
		int index = 0;
		while(index < citas.size() && citas.get(index) != null && !citas.get(index).getIdCita().equals(idCita) ) {
			index++;
		}
		if(index < citas.size() && citas.get(index) != null && citas.get(index).getIdCita().equals(idCita)) {
			citas.remove(index);
			this.eliminarCitaFichero(idCita);			
		}else {
			throw new CitaNoExiste(idCita);
		}
	}
	
	
	
	

	//Con el mismo medico
	public boolean modificarCita(String idCita ,Date fechaInicio, Date fechaFinal) throws FormatoFechaInvalida, CitaNoExiste, PersonaNoCitas, IOException, NoHayDisponibilidadCita, MedicoNoCitas { 
		//1. Comprobar fechas ¿Son despues de la fecha actual y la inicio está despues de la final?
		//2. Vamos a buscar la cita
		
		if(!this.congruenciaFechas(fechaInicio, fechaFinal)) {
			System.out.println("Aquí");
			throw new FormatoFechaInvalida();
		}
		Cita ctModificar = this.buscarCitaId(idCita);
		String CCMedico = ctModificar.getCCMedico();
		if(this.disponibilidadCita(CCMedico, fechaInicio, fechaFinal)) {
			//Modificamos la cita
			int indexCita = this.buscarCitaIdIndex(idCita);
			this.citas.get(indexCita).setFechaInicio(fechaInicio);
			this.citas.get(indexCita).setFechaFinal(fechaFinal);
			Calendar cfi = new GregorianCalendar();
			Calendar cff = new GregorianCalendar();
			cfi.setTime(fechaInicio);
			cff.setTime(fechaFinal);
			//Actualizamos fichero
			this.editarCitaFicero(idCita, ctModificar.getCCPaciente(), CCMedico, cfi, cff);
			return true;
			}
		return false;
	}
	
	//Con el medico distinto
	public boolean modificarCita(String idCita, String CCMedico ,Date fechaInicio, Date fechaFinal) throws IOException, FormatoFechaInvalida, NoHayDisponibilidadCita, CitaNoExiste {
		Cita ctModificar = this.buscarCitaId(idCita);
		
		try {
			if(this.disponibilidadCita(CCMedico, fechaInicio, fechaFinal) && this.congruenciaFechas(fechaInicio, fechaFinal) ) {
				//Modificamos la cita
				int indexCita = this.buscarCitaIdIndex(idCita);
				this.citas.get(indexCita).setFechaInicio(fechaInicio);
				this.citas.get(indexCita).setFechaFinal(fechaFinal);
				Calendar cfi = new GregorianCalendar();
				Calendar cff = new GregorianCalendar();
				cfi.setTime(fechaInicio);
				cff.setTime(fechaFinal);
				//Actualizamos fichero
				this.editarCitaFicero(idCita, ctModificar.getCCPaciente(), CCMedico, cfi, cff);
				return true;
				}
		} catch (MedicoNoCitas e) {
			if(this.congruenciaFechas(fechaInicio, fechaFinal)) {
				int indexCita = this.buscarCitaIdIndex(idCita);
				this.citas.get(indexCita).setFechaInicio(fechaInicio);
				this.citas.get(indexCita).setFechaFinal(fechaFinal);
				this.citas.get(indexCita).setCCMedico(CCMedico);
				Calendar cfi = new GregorianCalendar();
				Calendar cff = new GregorianCalendar();
				cfi.setTime(fechaInicio);
				cff.setTime(fechaFinal);
				//Actualizamos fichero
				this.editarCitaFicero(idCita, ctModificar.getCCPaciente(), CCMedico, cfi, cff);
				return true;
			}
			
			
		} 
		return false;
	}
	
	public boolean fechaDespuesActual(Date fi) {
		return fi.after(new Date());
	}
	
	public boolean hayHueco(Date citaIf, Date citaAi, Date citaAf, Date citaDi) {
		if(citaIf.after(citaAi) && citaDi.before(citaAf)) {
			return true;
		}else {
			return false;
		}
	}
	
	public ArrayList<Cita> getCitasArr() {
		return this.citas;
	}
	public Cita[] getCitas() {
		return this.ordenarCitas(this.citas);
	}
	
	public Cita buscarCitaId(String idCita) throws CitaNoExiste {
		for(Cita ct : this.citas) {
			if(ct.getIdCita().equals(idCita)) {
				return ct;
			}
		}
		throw new CitaNoExiste(idCita);	  
	}
	public int buscarCitaIdIndex(String idCita) throws CitaNoExiste {
		for(int i = 0; i < this.citas.size() ; i++) {
			if(this.citas.get(i) !=null && this.citas.get(i).getIdCita().equals(idCita)) {
				return i;
			}
		}
		throw new CitaNoExiste(idCita);	  
	}
	
	public Cita[] buscarCitaCedulaPaciente(String CC) throws PersonaNoCitas{
		ArrayList<Cita> citasN = new ArrayList<Cita>();
		for(Cita ct: this.citas) {
			if(ct !=null && ct.getCCPaciente().equals(CC)) {
				citasN.add(ct);
			}
		}
		if(citasN.size() != 0) {
			return ordenarCitas(citasN);
		}else {
			throw new PersonaNoCitas(CC);
		}
	}
	
	public Cita[] buscarCitaCedulaMedico(String CC) throws MedicoNoCitas{
		ArrayList<Cita> citasN = new ArrayList<Cita>();
		// 1. Obtengo el arreglo de citas
		for(Cita ct: this.citas) {
			if(ct !=null && ct.getCCMedico().equals(CC)) {
				citasN.add(ct);
			}
		}
		if(citasN.size() != 0) {
			return ordenarCitas(citasN);
		}else {
			throw new MedicoNoCitas(CC);
		}
	}
	
	public Cita[] ordenarCitas(ArrayList<Cita> citasN) {
		for(int i = 0; i < citasN.size(); i++) {
			for(int j = 0; j < citasN.size()-i-1; j++) {
				Cita c1 = citasN.get(j);
				Cita c2 = citasN.get(j+1);
				if((c1.getFechaInicio().after(c2.getFechaFinal()) || c1.getFechaInicio().getTime()-c2.getFechaFinal().getTime() == 0) && c1.getFechaFinal().after(c2.getFechaFinal())) { //Si fecha inicio está despues de siguiente fecha final, intercambiamos posiciones
					citasN.set(j+1, c1);
					citasN.set(j, c2);
				}
			}
		}
		return (Cita[]) citasN.toArray(new Cita[citasN.size()]);
	}
	
	
	
	
	public boolean disponibilidadCitaExtremos(Cita[] citasN, Date fi, Date ff) {
		//Suponiendo que la lista está ordenada
		if(citasN.length >0) {
			boolean condicionInicio = (fi.before(citasN[0].getFechaInicio())) && (ff.before(citasN[0].getFechaInicio()) || ff.getTime() -citasN[0].getFechaInicio().getTime() == 0 );
			boolean condicionFinal = (fi.after(citasN[citasN.length-1].getFechaFinal()) ||  fi.getTime() - citasN[citasN.length-1].getFechaFinal().getTime() == 0 ) && (ff.after(citasN[citasN.length-1].getFechaFinal()));
			if(condicionInicio || condicionFinal) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
		
		/*
		Date inicialMasCercana = citasN[0].getFechaInicio();
		Date finalMasLejana = citasN[0].getFechaFinal();
		for (int i = 1; i < citasN.length; i++) {
			//Minima
			if(inicialMasCercana.after(citasN[i].getFechaInicio())) {
				inicialMasCercana = citasN[i].getFechaInicio();
			}
			//Maxima
			if(finalMasLejana.before(citasN[i].getFechaFinal())) {
				finalMasLejana = citasN[i].getFechaFinal();
			}
		}
		//Comprobemos si la fecha estipulada está antes o despues de las maximas y minmas
		if((fi.before(inicialMasCercana) ||fi.getTime()) && ff.before(finalMasLejana)) {
			return true;
		}else if(fi.after(inicialMasCercana) && fi.after(finalMasLejana)){
			return true;
		}else {
			return false;
		}*/
	}
	
	public boolean disponibilidadCitaHuecos(Cita[] citasN, Date fi, Date ff) {
		//Suponiendo que citasN está ordenado
		boolean hayHueco = false;
		for(int i = 0; i<citasN.length-1; i++) {
			if((fi.after(citasN[i].getFechaFinal()) || fi.getTime()-citasN[i].getFechaFinal().getTime() == 0) && //Está despues o es justo la fecha final
				(ff.before(citasN[i+1].getFechaInicio()) || ff.getTime()-citasN[i+1].getFechaInicio().getTime() == 0)) {
				hayHueco = true;
				break;
			}
		}
		return hayHueco;
	}
	
	// Comparacion con fecha actual y fechas despues de otra y iguales
	public boolean congruenciaFechas(Date fi, Date ff) {
		if(this.fechaDespuesActual(fi) && fi.before(ff) ) {
			return true;
		}else {
			return false;
		}
	}

	
	public boolean disponibilidadCita(String CCMedico ,Date fi, Date ff) throws FormatoFechaInvalida, NoHayDisponibilidadCita, MedicoNoCitas{
		Cita[] citasMedico = this.buscarCitaCedulaMedico(CCMedico);
		// 1. Comparacion con fecha actual
		// 2. Comparacion con maximos y minimos
		// 3. Comparacion con huecos
		
		// Comparacion con fecha actual y fechas despues de otra y iguales
		if(!this.congruenciaFechas(fi, ff) ){
			throw new FormatoFechaInvalida();
		}
		// Comparación en minimos y maximos y en huecos
		if(this.disponibilidadCitaExtremos(citasMedico, fi, ff) || this.disponibilidadCitaHuecos(citasMedico, fi, ff)) {
			return true;
		}
		else {
			throw new NoHayDisponibilidadCita();
		}
	}
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
