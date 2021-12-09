package Dades;

import java.util.ArrayList;
import java.util.List;

public class ListaDinamicaRecurso implements interfaces.TADcjtRecurso{
	List <Recurso> list = new ArrayList<Recurso>();

	@Override
	public boolean afegirRecurs(Recurso r) {
		list.add(r);
		return false;
	}

	@Override
	public boolean EsborrarDadesConsulta(Recurso r) {
		
		return false;
	}

	@Override
	public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuari[] llistaUsuarisConsultat(String r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuari[] llistaUsuarisConsultatData(String r, Data d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recurso recursMesConsultat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recurso[] llistaConsultaUsuari(String aliesUser) {
		// TODO Auto-generated method stub
		return null;
	}
}
