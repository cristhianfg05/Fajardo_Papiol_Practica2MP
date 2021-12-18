package aplicacio;

import Dades.*;
import interfaces.TADcjtRecurso;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Time;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		int opcio;
		boolean sortir = false;
		// METODOS QUE FUNCIONAN DEL TAD-ESTATICO 1-2-3-4-5-6-7-8-9-10-11
		ListaRecursoEstatica listEst = afegirDadesDeFitxer(100);
		TADcjtRecurso cjt = new ListaRecursoDinamica();
		cjt = afegirDadesDeFitxer(1000);
		
		TADcjtRecurso cjt2 = new ListaRecursoEstatica();
		cjt2 = afegirDadesDeFitxer(1000);
		while (!sortir) {
			Scanner teclat = new Scanner(System.in);
			System.out.print("\n Memoria Dinamica [1] - Memoria Estàtica [2] - Sortir del programa [0] \n");
			opcio = teclat.nextInt();

			switch (opcio) {
			case 1:
				
				
				System.out.print(
						"Indica quina acció vols realitzar: \n [1] Consultar un cert alumne \n [2] Llistar els usuaris que han consultat en cert dia \n [3] Llistar els usuaris que han consultat en una franja \n [4] Consultat recursos d'un alumne \n [5] Eliminar consulta d'un cert recurs \n [6] Eliminar consulta d'un recurs en una data \n [7] Llistat d'usuaris d'un recurs \n [8] Llistat d'usuaris d'un recurs en una data \n [9] Recurs més consultat \n [10] Recursos consultats per un usuari ");
				opcio = teclat.nextInt();
				switch (opcio) {
				case 1:
					boolean trobat = false;
					String alumne;
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					if (cjt.consultarAlumne(alumne)) {
						System.out.println("L'usuari  està");
					} else {
						System.out.println("L'usuari no està");
					}
					break;
				case 2:
					int dia, mes, any;
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					Data d = new Data(dia, mes, any);
					System.out.println(cjt.llistatUsers(d));
					break;
				case 3:
					System.out.print("Introdueix el dia de la primera data que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes de la primera data que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any de la primera data que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);

					System.out.print("Introdueix el dia de la última data que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes de la última data que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any de la última data que vols consultar: ");
					any = teclat.nextInt();
					Data d1 = new Data(dia, mes, any);

					System.out.println(cjt.llistatUsersFranja(d, d1));
					break;
				case 4:
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					System.out.println(cjt.ConsultarRecursAlumne(alumne));
					break;
				case 5:
					int codi;
					int i=0;
					Recurso r = null;
					System.out.print("Introdueix el codi del recurs que vols eliminar les seves consultes: ");
					codi = teclat.nextInt();
					while (i<listEst.getNumRecursos()) {
						if (codi==listEst.getListaRecurso()[i].getCodigo()) {
							r=listEst.getListaRecurso()[i];
						}
					}
					
					if (cjt.EsborrarDadesConsulta(r)) {
						System.out.println("Eliminat correctament");
					} else {
						System.out.println("No eliminat");
					}
					break;
				case 6:
					r = null;
					i=0;
					System.out.print("Introdueix el codi del recurs que vols eliminar les seves consultes: ");
					codi = teclat.nextInt();
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);
					while (i<listEst.getNumRecursos()) {
						if (codi==listEst.getListaRecurso()[i].getCodigo()) {
							r=listEst.getListaRecurso()[i];
						}
					}
					if (cjt.EsborrarDadesConsultaData(r, d)) {
						System.out.println("Eliminat correctament");
					} else {
						System.out.println("No eliminat");
					}
					break;
				case 7:
					String nomrecurs;
					System.out.print("Introdueix el nom del recurs: ");
					nomrecurs = teclat.next();
					System.out.println(cjt.LlistatUserConsultaRecurs(nomrecurs));
					break;
				case 8:
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);
					System.out.print("Introdueix el nom del recurs: ");
					nomrecurs = teclat.next();
					System.out.println(cjt.LlistatUserConsultaRecursData(nomrecurs, d));
					break;
				case 9:
					System.out.println("El recurs més consultat és " + cjt.mesConsultat());
					break;
				case 10:
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					System.out.println(cjt.LlistaRecursosConsultatsAlies(alumne));
					break;
				default:
					System.out.println("No has introduit un valor correcte");
				}
				// System.out.print(cjt.getListaRecurso()[0]+"\n");
				break;
			case 2:
				System.out.print(
						"Indica quina acció vols realitzar: \n [1] Consultar un cert alumne \n [2] Llistar els usuaris que han consultat en cert dia \n [3] Llistar els usuaris que han consultat en una franja \n [4] Consultat recursos d'un alumne \n [5] Eliminar consulta d'un cert recurs \n [6] Eliminar consulta d'un recurs en una data \n [7] Llistat d'usuaris d'un recurs \n [8] Llistat d'usuaris d'un recurs en una data \n [9] Recurs més consultat \n [10] Recursos consultats per un usuari ");
				opcio = teclat.nextInt();
				switch (opcio) {
				case 1:
					boolean trobat = false;
					String alumne;
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					Node aux = cjt2.getPrimer();
					while (aux.getSeguent() != null) {
						if (cjt2.consultarAlumne(alumne)) {
							trobat = true;
						} else {
							trobat = false;
						}
						aux = aux.getSeguent();
					}
					if (trobat) {
						System.out.println("L'usuari  està");
					} else {
						System.out.println("L'usuari no està");
					}
					break;
				case 2:
					int dia, mes, any;
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					Data d = new Data(dia, mes, any);
					System.out.println(cjt2.llistatUsers(d));
					break;
				case 3:
					System.out.print("Introdueix el dia de la primera data que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes de la primera data que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any de la primera data que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);

					System.out.print("Introdueix el dia de la última data que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes de la última data que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any de la última data que vols consultar: ");
					any = teclat.nextInt();
					Data d1 = new Data(dia, mes, any);

					System.out.println(cjt2.llistatUsersFranja(d, d1));
					break;
				case 4:
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					System.out.println(cjt2.ConsultarRecursAlumne(alumne));
					break;
				case 5:
					int codi;
					Recurso r = null;
					System.out.print("Introdueix el codi del recurs que vols eliminar les seves consultes: ");
					codi = teclat.nextInt();
					aux = cjt2.getPrimer();
					while (aux.getSeguent() != null) {
						if (codi == aux.getR().getCodigo()) {
							r = aux.getR();
						}
						aux = aux.getSeguent();
					}
					if (cjt2.EsborrarDadesConsulta(r)) {
						System.out.println("Eliminat correctament");
					} else {
						System.out.println("No eliminat");
					}
					break;
				case 6:
					r = null;
					System.out.print("Introdueix el codi del recurs que vols eliminar les seves consultes: ");
					codi = teclat.nextInt();
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);
					aux = cjt2.getPrimer();
					while (aux.getSeguent() != null) {
						if (codi == aux.getR().getCodigo()) {
							r = aux.getR();
						}
						aux = aux.getSeguent();
					}
					if (cjt2.EsborrarDadesConsultaData(r, d)) {
						System.out.println("Eliminat correctament");
					} else {
						System.out.println("No eliminat");
					}
					break;
				case 7:
					String nomrecurs;
					System.out.print("Introdueix el nom del recurs: ");
					nomrecurs = teclat.next();
					System.out.println(cjt2.LlistatUserConsultaRecurs(nomrecurs));
					break;
				case 8:
					System.out.print("Introdueix el dia que vols consultar: ");
					dia = teclat.nextInt();
					System.out.print("Introdueix el mes que vols consultar:");
					mes = teclat.nextInt();
					System.out.print("Introdueix l'any que vols consultar: ");
					any = teclat.nextInt();
					d = new Data(dia, mes, any);
					System.out.print("Introdueix el nom del recurs: ");
					nomrecurs = teclat.next();
					System.out.println(cjt2.LlistatUserConsultaRecursData(nomrecurs, d));
					break;
				case 9:
					System.out.println("El recurs més consultat és " + cjt2.mesConsultat());
					break;
				case 10:
					System.out.print("Introdueix l'alumne que vols cercar: ");
					alumne = teclat.next();
					System.out.println(cjt2.LlistaRecursosConsultatsAlies(alumne));
					break;
				default:
					System.out.println("No has introduit un valor correcte");
				}
				break;
			case 0:
				sortir = true;
				System.out.println("Has sortit del programa \n");
				break;
			default:
				System.out.println("No has introduit un valor correcte \n");
			}
		}

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
		String[] fichero = llegirLiniesFitxer(linies);
		for (int i = 0; i < fichero.length; i++) {
			String[] aux = fichero[i].split(",");
			listEst.afegirRecurs(new Recurso(Integer.parseInt(aux[0]), aux[1]));
			boolean trobat = false;
			int j = 0;
			while (j < listEst.getNumRecursos() && !trobat) {
				if (listEst.getListaRecurso()[j].getNombre().equalsIgnoreCase(aux[1])) {
					trobat = true;
				}
				j++;
			}
			j--;
			listEst.afegirVisita(listEst.getListaRecurso()[j].getNombre(),
					new Visita(Integer.parseInt(aux[2]), aux[3],
							new Data(Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), Integer.parseInt(aux[6])),
							Time.valueOf(aux[7])));

		}
		return listEst;
	}

	private static ListaRecursoDinamica afegirDadesDeFitxer2(int linies) throws FileNotFoundException {
		ListaRecursoDinamica listEst = new ListaRecursoDinamica();
		String[] fichero = llegirLiniesFitxer(linies);
		for (int i = 0; i < fichero.length; i++) {
			String[] aux = fichero[i].split(",");
			listEst.afegirRecurs(new Recurso(Integer.parseInt(aux[0]), aux[1]));
			boolean trobat = false;
			int j = 0;
			Node nodeAux = listEst.getPrimer();
			while (j < listEst.getNumElem() && !trobat) {
				if (nodeAux.getR().getNombre().equalsIgnoreCase(aux[1])) {
					trobat = true;
				} else {
					j++;
					nodeAux = nodeAux.getSeguent();
				}

			}
			listEst.afegirVisita(nodeAux.getR().getNombre(),
					new Visita(Integer.parseInt(aux[2]), aux[3],
							new Data(Integer.parseInt(aux[4]), Integer.parseInt(aux[5]), Integer.parseInt(aux[6])),
							Time.valueOf(aux[7])));

		}
		return listEst;
	}
}