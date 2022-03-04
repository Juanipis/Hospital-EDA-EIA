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
	
	
	public static void main(String[] args) {
		try {
			Main.inicializacionFicheros();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Hospital hp = new Hospital();
			hp.addMedico("Juanito", "Perez", "2190120", true, "Medico general", true);
		} catch (IOException | ExistePersonal  e) {
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
	
	public static File recuperarFichero(String nombreFichero) throws FileNotFoundException {
		int index = 0;
		while(index < Main.ficheros.length && Main.ficheros[index] != null && !Main.ficheros[index].getName().equals(nombreFichero)) {
			index++;
		}
		
		if(index < Main.ficheros.length && Main.ficheros[index] != null && Main.ficheros[index].getName().equals(nombreFichero)) {
			return Main.ficheros[index];
		}else {
			throw new FileNotFoundException();
		}	
	}
	
	public static void escrituraFicheroUltimaLinea(String nombreFichero, String datos) throws FileNotFoundException, IOException {
		FileWriter fich = new FileWriter(Main.recuperarFichero(nombreFichero).getAbsoluteFile(), true);
		fich.write(datos + "\n");
		fich.close();
	}
	
	public static void eliminarAlgoFicheroId(String nombreFichero, String id) throws IOException, FileNotFoundException {
		File inputFile = Main.recuperarFichero(nombreFichero);
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
	
	public static void editarAlgoFicheroId(String nombreFichero, String id, String nuevosDatos) throws IOException, FileNotFoundException {
		File inputFile = Main.recuperarFichero(nombreFichero);
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


