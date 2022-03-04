package hospital;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
	private static File[] ficheros = {new File("cita.txt"), new File("pacientes.txt"), new File("personal.txt"), new File("salas.txt")}; //Agrega aqu� los ficheros a usar
	private static File[] historialMedico = new File("historialMedico").listFiles();
	
	public static void main(String[] args) {
		try {
			Hospital hp = new Hospital();
			hp.addPaciente("Pepito", "Perez", "123612", "Sura", new String[]{"Covid"}, 0, new String[]{"Jhoan"}, 23, "M", "A+");
			hp.getPaciente("123612").addHistorial(new String[] {""}, new String[] {"Cabeza"}, new String[] {"Huevo"},"hsdb3b12");
			System.out.println(Arrays.toString(hp.getPaciente("123612").getHistorial()));
		} catch (IOException | ExistePersonal e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	//Metodos para la recuperacion,escritura,eliminacionId y edicionId de los ficheros
	public static void inicializacionFicheros() throws IOException {
		for(File fl: ficheros) {
			if(!fl.exists()) {
				fl.createNewFile();
			}
		}
	}
	public static void crearFichero(String nombreFichero, int TypeList) throws IOException {
		if(TypeList == 0) { //Crear fichero en directorio
			new File(nombreFichero).createNewFile();
		}
		else if(TypeList == 1) { //Crear fichero de historial
			new File("historialMedico/" + nombreFichero).createNewFile();
		}
	}
	/*
	 * TypeList refiere a la lista de archivos a obtener, 0: ficheros, 1: historialMedico
	 */
	public static File recuperarFichero(String nombreFichero, int typeList) throws FileNotFoundException {
		if(typeList == 0) {
			int index = 0;
			while(index < Main.ficheros.length && Main.ficheros[index] != null && !Main.ficheros[index].getName().equals(nombreFichero)) {
				index++;
			}
			
			if(index < Main.ficheros.length && Main.ficheros[index] != null && Main.ficheros[index].getName().equals(nombreFichero)) {
				return Main.ficheros[index];
			}else {
				throw new FileNotFoundException();
			}
		}else if(typeList == 1) {
			int index = 0;
			while(index < Main.historialMedico.length && Main.historialMedico[index] != null && !Main.historialMedico[index].getName().equals(nombreFichero)) {
				index++;
			}
			
			if(index < Main.historialMedico.length && Main.historialMedico[index] != null && Main.historialMedico[index].getName().equals(nombreFichero)) {
				return Main.historialMedico[index];
			}else {
				throw new FileNotFoundException();
			}
		}else {
			throw new FileNotFoundException();
		}
			
	}
	
	public static void escrituraFicheroUltimaLinea(String nombreFichero, String datos, int typeList) throws FileNotFoundException, IOException {
		FileWriter fich = new FileWriter(Main.recuperarFichero(nombreFichero, typeList).getAbsoluteFile(), true);
		fich.write(datos + "\n");
		fich.close();
	}
	
	public static void eliminarAlgoFicheroId(String nombreFichero, String id, int typeList) throws IOException, FileNotFoundException {
		File inputFile = Main.recuperarFichero(nombreFichero, typeList);
        File tempFile = new File("fichTemp.txt");
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.contains(id)) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
	}
	
	public static void editarAlgoFicheroId(String nombreFichero, String id, String nuevosDatos, int typeList) throws IOException, FileNotFoundException {
		File inputFile = Main.recuperarFichero(nombreFichero, typeList);
        File tempFile = new File("fichTemp.txt");
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
        	if (currentLine.contains(id)) {
        		writer.write(nuevosDatos + System.getProperty("line.separator"));
        		continue;
        	}
        	writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
	}

}


