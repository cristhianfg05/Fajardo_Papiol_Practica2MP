package interfaces;

import Dades.Data;
import Dades.Recurso;

public interface TADcjtRecurso {

	boolean afegirRecurs(Recurso r);
	boolean EsborrarDadesConsulta(Recurso r);
	boolean EsborrarDadesConsultaData(Recurso r,Data d);
	String[] llistaUsuarisConsultat(String r);
	String[] llistaUsuarisConsultatData(String r,Data d);
	Recurso recursMesConsultat();
	Recurso[] llistaConsultaUsuari(String aliesUser);
	
}