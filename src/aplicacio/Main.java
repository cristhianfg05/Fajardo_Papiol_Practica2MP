package aplicacio;


import Dades.*;
import interfaces.TADcjtRecurso;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		//METODOS QUE FUNCIONAN DEL TAD-ESTATICO 1-2-3-4-5-6-7-8-9-10-11
		ListaRecursoEstatica listEst = afegirDadesDeFitxer(100);
		//String [] fichero = llegirLiniesFitxer(10000);
		/*for (int i = 0; i < fichero.length; i++) {
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
			
		}*/
		//System.out.print(listEst.toString());
		/*System.out.println(listEst.getListaRecurso()[0]);
		System.out.println("------------------------------------------------");
		listEst.QuickSortData(listEst.getListaRecurso()[0].getListaVisita(),0,listEst.getListaRecurso()[0].getNumVisita()-1);
		System.out.println(listEst.getListaRecurso()[0]);
		System.out.println("------------------------------------------------");
		listEst.QuickSortHora(listEst.getListaRecurso()[0].getListaVisita(),0,listEst.getListaRecurso()[0].getNumVisita()-1);
		System.out.println(listEst.getListaRecurso()[0]);*/
		TADcjtRecurso cjt = new ListaRecursoEstatica();
		cjt = afegirDadesDeFitxer(100);
		System.out.print(cjt.getListaRecurso()[0].getNombre());

	}

		private static String[] llegirLiniesFitxer(int nLinies) throws FileNotFoundException {
			String[] result;
			if (nLinies < 0)
				nLinies = 0;
			if (nLinies > 10000)
				nLinies = 10000;
			result = new String[nLinies];
			Scanner f = new Scanner(new File("Recursos MP.csv"));
			for (int i = 0; i < nLinies; i++) {
				result[i] = f.nextLine();
			}
			f.close();
			return result;
		}	
		
		private static ListaRecursoEstatica afegirDadesDeFitxer(int linies) throws FileNotFoundException {
			ListaRecursoEstatica listEst = new ListaRecursoEstatica();
			String [] fichero = llegirLiniesFitxer(linies);
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
						new Visita(Integer.parseInt(aux[2]),aux[3],new Data(Integer.parseInt(aux[4]),Integer.parseInt(aux[5]),Integer.parseInt(aux[6])),Time.valueOf(aux[7])));
				
			}
			return listEst;
		}
		
	}


