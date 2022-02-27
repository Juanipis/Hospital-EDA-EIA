package hospital;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class AgendaHospital {
	private ArrayList<Cita> citas = new ArrayList<Cita>();
	private File agendaCitas = new File("cita.txt");

	public AgendaHospital() {
		super();
		//Recuperar todas las citas
		this.recuperarCitas();
	}
	
	
	public void recuperarCitas() {
		try {
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
		} catch (IOException e) {
			 e.printStackTrace();
		}
	}
	
	public void generarCita(String CCPaciente, String CCMedico, int [] fechaInicio, int [] fechaFinal ) throws FormatoFechaInvalida, IOException {
		// Es necesario comprobar si el medico y el paciente existen en el hospital y devolver un true or false
		// int[] fechaI :  int Iano, int Imes, int dia, int Ihora, int Iminuto
		// Es neceario comprobar ademas que la fecha a agregar no tenga conflicto con las fechas del medico
		if(fechaInicio.length == 5 && fechaFinal.length == 5) {
			try {
				FileWriter fichero = new FileWriter(agendaCitas.getAbsoluteFile(), true);
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
				fichero.write(cita.toString() + "\n");
				fichero.close();
				citas.add(new Cita(CCPaciente, CCMedico, fi.getTime(), ff.getTime(), idCita));
			} catch (IOException e) {
				throw e;
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
	
	
	
	public void modificarCita(String idCita ,Date fechaInicio, Date fechaFinal) throws FormatoFechaInvalida{
		// 1. ¿La fecha inicio es despues de la fecha actual?
		// 2. ¿La fecha inicio está antes de la fecha final?
		// 3. Buscamos medico
		// 4. Iterar sobre sus citas
		// 5. Buscar hueco de a pares ¿La fecha final de la cita anterior está despues de la fecha de la inicio de la nueva cita? ¿La fecha final está antes de la fecha de inicio de la actual cita?, aquí hay que considerar si es la primera iteración y la final.
		// 6. Modificamos la cita con los set, si es el mismo medico sobreescribimos al medico y actalizamos su 
		
		if(this.fechaDespuesActual(fechaInicio) && fechaFinal.after(fechaInicio)) {
			
		}else {
			throw new FormatoFechaInvalida();
		}
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
	
	public ArrayList<Cita> getCitas() {
		return this.citas;
	}
	
	public Cita buscarCitaId(String idCita) throws CitaNoExiste {
		for(Cita ct : this.citas) {
			if(ct.getIdCita().equals(idCita)) {
				return ct;
			}
		}
		throw new CitaNoExiste(idCita);	  
	}
	
	public Cita[] buscarCitaCedulaPaciente(String CC) throws PersonaNoCitas{
		ArrayList<Cita> citasN = new ArrayList<Cita>();
		for(Cita ct: this.citas) {
			if(ct.getCCPaciente().equals(CC)) {
				citasN.add(ct);
			}
		}
		if(citasN.size() != 0) {
			return (Cita[]) citasN.toArray(new Cita[this.citas.size()]);
		}else {
			throw new PersonaNoCitas(CC);
		}
	}
	
	public Cita[] buscarCitaCedulaMedico(String CC) throws PersonaNoCitas{
		ArrayList<Cita> citasN = new ArrayList<Cita>();
		for(Cita ct: this.citas) {
			if(ct.getCCMedico().equals(CC)) {
				citasN.add(ct);
			}
		}
		if(citasN.size() != 0) {
			return (Cita[]) citasN.toArray(new Cita[this.citas.size()]);
		}else {
			throw new PersonaNoCitas(CC);
		}
	}
	
	
	public boolean disponibilidadCitaExtremos(Cita[] citasN, Date fi, Date ff) {
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
		if(fi.before(inicialMasCercana) && ff.before(finalMasLejana)) {
			return true;
		}else if(fi.after(inicialMasCercana) && fi.after(finalMasLejana)){
			return true;
		}else {
			return false;
		}
	}
	
	public boolean disponibilidadCitaHuecos(Cita[] citasN, Date fi, Date ff) {
		long diffInicial = Long.MAX_VALUE; // El mayor valor para evitar problemas
		long diffFinal = Long.MIN_VALUE; // El menor valor para evitar problemas
		long diffActFinal, diffActInicial;
		int indexFinalMasCercana, indexInicialMasCercana;
		//1. Encontrar fecha final mas cercana a nuestra fecha inicial
		for (int i = 0; i < citasN.length; i++) {
			// ¿Cual es la fecha inicial mas cercana a una fecha final?
			diffActInicial = fi.getTime() - citasN[i].getFechaFinal().getTime();
			System.out.println(diffActInicial);
			if(diffActInicial >= 0 && diffActInicial < diffInicial && fi.after(citasN[i].getFechaInicio())) { 
				//Debemos comprobar tambien que esta no este antes de una final
				diffInicial = diffActInicial;
				indexInicialMasCercana = i;
				
			}
			
			// ¿Cual es la fecha final mas cercana a una fecha inicial?
			diffActFinal = ff.getTime() - citasN[i].getFechaInicio().getTime() ;
			
			if(diffActFinal <= 0 && diffActFinal > diffFinal ) { 
				//Condicion especial para saber si estamos en un tope
				diffFinal = diffActFinal;
				indexFinalMasCercana = i;
			}
		}
		System.out.println("------------");
		System.out.println(diffInicial);
		System.out.println(diffFinal);
		if(diffInicial == 0 && diffFinal == 0) { //En caso de instantes entre topes
			return true;
		}
		else if(diffInicial == 0 && diffFinal > Long.MIN_VALUE) {
			return true;
		}
		else if(diffInicial < Long.MAX_VALUE && diffFinal == 0) {
			return true;
		}
		else if(diffInicial < Long.MAX_VALUE && diffFinal > Long.MIN_VALUE) { //Significa que los valores se sobrescribieron y nos indica que hay un hueco
			return true;
		}else {
			return false;
		}
	}
	
	public boolean disponibilidadCita(String CCMedico ,Date fi, Date ff) throws PersonaNoCitas {
		try {
			Cita[] citasMedico = this.buscarCitaCedulaMedico(CCMedico);
			// 1. Comparacion con fecha actual
			// 1. Comparacion con maximos y minimos
			// 2. Comparacion con huecos
			
			// Comparacion con fecha actual y fechas despues de otra y iguales
			if(!this.fechaDespuesActual(fi) || fi.after(ff) || fi.equals(ff) ) {
				return false;
			}
			// Comparación en minimos y maximos
			if(this.disponibilidadCitaExtremos(citasMedico, fi, ff)) {
				return true;
			}
			// Comparacion en huecos
			else if(this.disponibilidadCitaHuecos(citasMedico, fi, ff)) {
				return true;
			}
			else {
				return false;
			}
			
			
		} catch (PersonaNoCitas e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return true;
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
