package gestion;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import laboral.DatosNoCorrectosException;
import laboral.Empleado;

public class Ficheros {
	
	BBDD bbdd;
	
	public Ficheros() throws ClassNotFoundException, SQLException {
		bbdd = new BBDD();
	}
	
	private List<String> leerficheroempleados() throws FileNotFoundException {
		File empleados = new File("empleados.txt");
		List<String> listaempleados = new ArrayList<String>();
		

        Scanner sc=new Scanner(empleados);
        while(sc.hasNextLine()){
            listaempleados.add(sc.nextLine());
        }
        
        return listaempleados;

	}
	
	public void altaempleados() throws FileNotFoundException, DatosNoCorrectosException, SQLException {
		File altas = new File("empleadosNuevos.txt");
		Scanner sc = new Scanner(altas);
				
		while(sc.hasNext()) {
			Empleado nuevoempl;
			
			String linea = sc.nextLine();
			String [] campos = linea.split(",");
			if(campos.length == 3) {
				nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0));
				bbdd.altaempleado(nuevoempl);
			}else if (campos.length == 5) {
				System.out.println(campos[4]);
				nuevoempl = new Empleado(campos[0].trim(), campos[1].trim().toUpperCase(), campos[2].trim().toUpperCase().charAt(0), Integer.parseInt(campos[3].trim()), Integer.parseInt(campos[4].trim()));
				bbdd.altaempleado(nuevoempl);
			}else {
				throw new DatosNoCorrectosException("Algo va mal a la hora de leer el fichero empleadosNuevos.txt");
			}
			
		}
		
	}
	
	
	
}