package interfaces;

import Dades.Data;
import Dades.Recurso;
import Dades.Visita;

public interface TADcjtRecurso {

	int getNumRecursos();
	Recurso[] getListaRecurso();
	boolean afegirRecurs(Recurso r);
	boolean afegirVisita(String r, Visita v);
	boolean consultarAlumne(String alum); 							//CONSULTAR USUARI DONAT UN ALIES
	String [] llistatUsers(Data d);									//CONSULTAR USUARIS EN CERT DIA
	String [] llistatUsersFranja(Data d1, Data d2);					//CONSULTAR USUARIOS EN FRANJA DE DIES
	Recurso [] ConsultarRecursAlumne(String alum);					//CONSULTAR RECURSOS D'UN ALUMNE
	boolean EsborrarDadesConsulta(Recurso r);						//ELIMINAR CONSULTA DE UN RECURSO
	boolean EsborrarDadesConsultaData(Recurso r, Data d);			//ELIMINAR CONSULTA RECURSO SEGUN DATA
	String [] LlistatUserConsultaRecurs(String recurs);				//LLISTA USER D'UN RECURS
	String [] LlistatUserConsultaRecursData(String recurs, Data d);	//LLISTA USERS D'UN RECURS AMB DATA
	Recurso mesConsultat();											//RETORNA EL RECURS MES CONSULTAT
	Recurso[] LlistaRecursosConsultatsAlies(String alies);			//LLISTA RECURSOS D'UN USUARI
	void QuickSortHora(Visita[] v,int izq, int der);
	void QuickSortData(Visita[] v,int izq, int der);
	
	
}