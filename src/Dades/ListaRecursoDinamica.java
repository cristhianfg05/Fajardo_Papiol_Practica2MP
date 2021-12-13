package Dades;

import java.util.ArrayList;

import interfaces.TADcjtRecurso;

public class ListaRecursoDinamica implements TADcjtRecurso{
	private ArrayList<Recurso> listaRecursos = new ArrayList<Recurso>();
	//TIENES QUE SER UNA LISTA ENLAZADA
	public ListaRecursoDinamica() {
	}
	
	public boolean afegirRecurs(Recurso r) {
		if(listaRecursos.contains(r)) {
			return false;
		}
		return listaRecursos.add(r);
	}

	@Override
	public boolean consultarAlumne(String alum) {
		for (Recurso recurso : listaRecursos) {
			for(int j = 0; j<recurso.getNumVisita(); j++) {
				if(recurso.getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum))
					return true;
			}
		}
		return false;
	}

	@Override
	public String[] llistatUsers(Data d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] llistatUsersFranja(Data d1, Data d2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recurso[] ConsultarRecursAlumne(String alum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean EsborrarDadesConsulta(Recurso r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] LlistatUserConsultaRecurs(String recurs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] LlistatUserConsultaRecursData(String recurs, Data d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recurso mesConsultat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Recurso[] LlistaRecursosConsultatsAlies(String alies) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
