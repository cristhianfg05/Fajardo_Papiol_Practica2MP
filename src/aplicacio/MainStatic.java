package aplicacio;


import Dades.*;
import java.sql.Time;
import java.util.Iterator;

public class MainStatic {

	public static void main(String[] args) {
		//METODOS QUE FUNCIONAN DEL TAD-ESTATICO 1-2-3-4-5-6-7-8-9-10-11
		ListaRecursoEstatica listEst = new ListaRecursoEstatica();
		listEst.afegirRecurs(new Recurso(0, "Recurso Prueba 0"));
		listEst.afegirRecurs(new Recurso(1, "Recurso Prueba 1"));
		listEst.afegirRecurs(new Recurso(2, "Recurso Prueba 2"));
		listEst.afegirRecurs(new Recurso(3, "Recurso Prueba 3"));
		listEst.getListaRecurso()[1].afegirVisita(new Visita(1,new Data(1,12,2005),new Time(2342342),"alumne1"));
		listEst.getListaRecurso()[1].afegirVisita(new Visita(1,new Data(12,3,2005),new Time(3465243),"alumne2"));
		listEst.getListaRecurso()[0].afegirVisita(new Visita(1,new Data(1,12,2005),new Time(2342342),"alumne1"));
		listEst.getListaRecurso()[3].afegirVisita(new Visita(1,new Data(1,12,2005),new Time(2342342),"alumne1"));
		//System.out.print(listEst.toString());
		/*Recurso []a = listEst.ConsultarRecursAlumne("alumne1");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\n");
		}*/
		//System.out.print(listEst.toString());
		//listEst.EsborrarDadesConsultaData(listEst.getListaRecurso()[1],new Data(1,12,2005));
		//System.out.print(listEst.toString());
		/*String []a = listEst.LlistatUserConsultaRecursData("Recurso Prueba 1",new Data(1,12,2005));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\n");
		}*/
		
		/*Recurso []a = listEst.LlistaRecursosConsultatsAlies("alumne1");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+"\n");
		}*/
	}

}
