package aplicacio;


import Dades.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Scanner;

public class MainStatic {

	public static void main(String[] args) throws FileNotFoundException {
		//METODOS QUE FUNCIONAN DEL TAD-ESTATICO 1-2-3-4-5-6-7-8-9-10-11
		ListaRecursoEstatica listEst = new ListaRecursoEstatica();
		String [] fichero = llegirLiniesFitxer(1000);
		for (int i = 0; i < fichero.length; i++) {
			System.out.print("Linea "+i+"-"+fichero[i]+"\n");
		}
		for (int i = 0; i < fichero.length; i++) {
			String []aux = fichero[i].split(",");
			listEst.afegirRecurs(new Recurso(Integer.parseInt(aux[0]), aux[1]));
			boolean trobat = false;
			int j = 0;
			while(j<listEst.getNumRecursos() && !trobat) {
				if(listEst.getListaRecurso()[j].getNombre().equalsIgnoreCase(aux[1])) {
					trobat = true;
				}
					j++;
			}
			j--;
			listEst.afegirVisita(
					listEst.getListaRecurso()[j].getNombre(),
					new Visita(Integer.parseInt(aux[2]),aux[3],new Data(Integer.parseInt(aux[4]),Integer.parseInt(aux[5]),Integer.parseInt(aux[6])),new Time(Long.parseLong(aux[7]))));
			
		}
		System.out.print(listEst.consultarAlumne("Aloïs"));
		
	}

		private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
			String[] result;
			if (nLinies < 0)
				nLinies = 0;
			if (nLinies > 1000)
				nLinies = 1000;
			result = new String[nLinies];
			Scanner f = new Scanner(new File("Recursos MP.csv"));
			for (int i = 0; i < nLinies; i++) {
				result[i] = f.nextLine();
			}
			f.close();
			return result;
		}	
		
	}


