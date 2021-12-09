package interfaces;

import Dades.Data;
import Dades.Recurso;
import Dades.Usuari;

public interface TADcjtRecurso {

	boolean afegirRecurs(Recurso r);
	boolean EsborrarDadesConsulta(Recurso r);
	boolean EsborrarDadesConsultaData(Recurso r,Data d);
	Usuari[] llistaUsuarisConsultat(String r);
	Usuari[] llistaUsuarisConsultatData(String r,Data d);
	Recurso recursMesConsultat();
	Recurso[] llistaConsultaUsuari(String aliesUser);
	
}