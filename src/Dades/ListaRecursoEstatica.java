package Dades;

import interfaces.TADcjtRecurso;

public class ListaRecursoEstatica implements TADcjtRecurso {
	private Recurso[] listaRecurso;
	private int numRecursos;

	public ListaRecursoEstatica() {
		this.listaRecurso = new Recurso[100];
		this.numRecursos = 0;
	}

	@Override
	public boolean afegirRecurs(Recurso r) {
		if (!(numRecursos == listaRecurso.length)) {
			listaRecurso[numRecursos] = r;
			numRecursos++;
			return true;
		}
		return false;
	}

	@Override
	public boolean consultarAlumne(String alum) {
		int i = 0;
		boolean trobat = false;
		while (!trobat && i < numRecursos) {
			int j = 0;
			while (!trobat && j < listaRecurso[i].getNumVisita()) {
				if (listaRecurso[i].getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
					trobat = true;
				}
				j++;
			}
			i++;
		}
		return trobat;
	}

	@Override
	public String[] llistatUsers(Data d) {
		String[] aux = new String[100];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
				if (listaRecurso[i].getListaVisita()[j].getData().esIgual(d)) {
					aux[c] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
		}
		return aux;
	}

	@Override
	public String[] llistatUsersFranja(Data d1, Data d2) {
		if (!(d1.esDataInferiorOigual(d2))) {
			Data aux = d1;
			d1 = d2;
			d2 = aux;
		}
		String[] aux = new String[100];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
				if (listaRecurso[i].getListaVisita()[j].getData().esDataInferiorOigual(d2) && !(listaRecurso[i].getListaVisita()[j].getData().esDataInferiorOigual(d1))) {	//SI DATA ESTA EN LA FRANJA
					aux[c] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
		}
		return aux;
	}

	@Override
	public Recurso[] ConsultarRecursAlumne(String alum) {
		Recurso[]aux = new Recurso[numRecursos];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < listaRecurso[i].getNumVisita() && !trobat) {
				if(listaRecurso[i].getListaVisita()[j].getAliesAlum().equals(alum)) {
					aux[c]=listaRecurso[i];
					c++;
					trobat = true;
				}
				j++;
			}
		}
		return aux;
	}

	@Override
	public boolean EsborrarDadesConsulta(Recurso r) {
		r.setListaVisita(new Visita[100]);
		r.setNumVisita(0);
		return false;
	}

	@Override
	public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
				if(listaRecurso[i].getListaVisita()[j].getData().esIgual(d)) {
					listaRecurso[i].getListaVisita()[j] = listaRecurso[i].getListaVisita()[listaRecurso[i].getNumVisita()-1];
					r.setNumVisita(r.getNumVisita()-1);
					c++;
				}
			}
		}
		return c!=0;
	}

	@Override
	public String[] LlistatUserConsultaRecurs(String recurs) {
		String aux []= new String[100];
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
