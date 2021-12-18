package Dades;


import interfaces.TADcjtRecurso;

public class ListaRecursoEstatica implements TADcjtRecurso {
	private Recurso[] listaRecurso;
	private int numRecursos;

	public ListaRecursoEstatica() {
		this.listaRecurso = new Recurso[10000];
		this.numRecursos = 0;
	}

	@Override
	public boolean afegirVisita(String r, Visita v) {
		int i = 0;
		boolean trobat = false;
		boolean afegit = false;
		while (i < numRecursos && !trobat) {
			if (listaRecurso[i].getNombre().equalsIgnoreCase(r)) {
				afegit = listaRecurso[i].afegirVisita(v);
				trobat = true;
			} else
				i++;
		}
		return afegit;
	}

	@Override
	public boolean afegirRecurs(Recurso r) {
		int i = 0;
		while (i < numRecursos) {
			if (listaRecurso[i].getNombre().equalsIgnoreCase(r.getNombre())) {
				return false;
			}
			i++;
		}
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
		String[] users = new String[10000];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
				if (listaRecurso[i].getListaVisita()[j].getData().esIgual(d)) {
					users[c] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
		}
		String[] s = new String[c];
		for (int i = 0; i < c; i++) {
			s[i] = users[i];
		}
		return s;
	}

	@Override
	public String[] llistatUsersFranja(Data d1, Data d2) {
		if (!(d1.esDataInferiorOigual(d2))) {
			Data aux = d1;
			d1 = d2;
			d2 = aux;
		}
		String[] alum = new String[10000];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
				if (listaRecurso[i].getListaVisita()[j].getData().esDataInferiorOigual(d2)
						&& !(listaRecurso[i].getListaVisita()[j].getData().esDataInferiorOigual(d1))) { // SI DATA ESTA
																										// EN LA FRANJA
					alum[c] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
		}
		String[] s = new String[c];
		for (int i = 0; i < c; i++) {
			s[i] = alum[i];
		}
		return s;
	}

	@Override
	public Recurso[] ConsultarRecursAlumne(String alum) {
		Recurso[] recursos = new Recurso[numRecursos];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < listaRecurso[i].getNumVisita() && !trobat) {
				if (listaRecurso[i].getListaVisita()[j].getAliesAlum().equals(alum)) {
					recursos[c] = listaRecurso[i];
					c++;
					trobat = true;
				}
				j++;
			}
		}
		// Para evitar problemass con los elementos null creamos otro array para enviar
		// este con los elementos del anterior asi redimensionandolo
		Recurso[] r = new Recurso[c];
		for (int i = 0; i < c; i++) {
			r[i] = recursos[i];
		}
		return r;
	}

	@Override
	public boolean EsborrarDadesConsulta(Recurso r) {//EL RECURSO ENVIADO ES UNA INSTANCIA DE LA LISTA
		r.setListaVisita(new Visita[10000]);
		r.setNumVisita(0);
		return true;
	}

	@Override
	public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
		int i = 0;
		boolean trobat = false;
		while(i<numRecursos && !trobat) {
			if(listaRecurso[i].getNombre().equalsIgnoreCase(r.getNombre())){
				trobat = true;
			}else
				i++;
		}
		int j = 0;
		boolean borrado = false;
		while(j < listaRecurso[i].getNumVisita()) {
			if(listaRecurso[i].getListaVisita()[j].getData().esIgual(d)) {
				Visita [] aux = listaRecurso[i].getListaVisita();
				aux[j] = listaRecurso[i].getListaVisita()[listaRecurso[i].getNumVisita()-1];
				listaRecurso[i].setListaVisita(aux);
				listaRecurso[i].setNumVisita(listaRecurso[i].getNumVisita()-1);
				borrado = true;
				j--;
			}
			j++;
		}
		return borrado;
	}

	@Override
	public String[] LlistatUserConsultaRecurs(String recurs) {
		String alum[] = new String[10000];
		int i = 0;
		boolean trobat = false;
		while (i < numRecursos && !trobat) {
			if (listaRecurso[i].getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else
				i++;
		}
		int j = 0;
		for (; j < listaRecurso[i].getNumVisita(); j++) {
			alum[j] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
		}
		String[] s = new String[j];
		for (int k = 0; k < j; k++) {
			s[k] = alum[k];
		}
		return s;
	}

	@Override
	public String[] LlistatUserConsultaRecursData(String recurs, Data d) {
		String alum[] = new String[10000];
		int i = 0;
		boolean trobat = false;
		while (i < numRecursos && !trobat) {
			if (listaRecurso[i].getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else
				i++;
		}
		int c = 0;
		for (int j = 0; j < listaRecurso[i].getNumVisita(); j++) {
			if (listaRecurso[i].getListaVisita()[j].getData().esIgual(d)) {
				alum[c] = listaRecurso[i].getListaVisita()[j].getAliesAlum();
				c++;
			}
		}
		String[] s = new String[c];
		for (int k = 0; k < c; k++) {
			s[k] = alum[k];
		}
		return s;
	}

	@Override
	public Recurso mesConsultat() {
		Recurso mesConsultat = null;
		int mesConsultatNum = -1;
		for (int i = 0; i < numRecursos; i++) {
			if (listaRecurso[i].getNumVisita() > mesConsultatNum) {
				mesConsultatNum = listaRecurso[i].getNumVisita();
				mesConsultat = listaRecurso[i].copia();
			}
		}
		return mesConsultat;
	}
	
	@Override
	public Recurso[] getListaRecurso() {
		return listaRecurso;
	}

	@Override
	public int getNumRecursos() {
		return numRecursos;
	}

	@Override
	public Recurso[] LlistaRecursosConsultatsAlies(String alies) {
		Recurso[] recursos = new Recurso[10000];
		int c = 0;
		for (int i = 0; i < numRecursos; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < listaRecurso[i].getNumVisita() && !trobat) {
				if (listaRecurso[i].getListaVisita()[j].getAliesAlum().equals(alies)) {
					trobat = true;
					recursos[c] = listaRecurso[i];
					c++;
				} else
					j++;
			}
		}
		Recurso[] s = new Recurso[c];
		for (int i = 0; i < c; i++) {
			s[i] = recursos[i];
		}
		return s;
	}

	@Override
	public String toString() {
		String concat = "";
		for (int i = 0; i < numRecursos; i++) {
			concat = concat + "Recurso: " + listaRecurso[i].toString() + "\n";
		}
		return "ListaRecursoEstatica [listaRecurso=\n" + concat + ", numRecursos=" + numRecursos + "]";
	}
	
	public void QuickSortData(Visita[] v,int izq, int der) {
		Visita pivote = v[izq].copia();
		int i = izq;
		int j = der;
		Visita aux;
		
		while(i<j) {
			while(v[i].getData().esDataInferiorOigual(pivote.getData()) && i<j) 
				i++;
			while(!(v[j].getData().esDataInferiorOigual(pivote.getData())))
				j--;
			if(i<j) {
				aux = v[i].copia();
				v[i] = v[j].copia();
				v[j] = aux.copia();
			}
		}
		v[izq] = v[j].copia();
		v[j] = pivote.copia();
		
		if(izq < j-1) 
			QuickSortData(v, izq, j-1);
		if(j+1 < der)
			QuickSortData(v, j+1, der);
	}
	
	public void QuickSortHora(Visita[] v,int izq, int der) {
		Visita pivote = v[izq].copia();
		int i = izq;
		int j = der;
		Visita aux;
		
		while(i<j) {
			while(v[i].getHora().compareTo(pivote.getHora()) <=0 && i<j) 
				i++;
			while(v[j].getHora().compareTo(pivote.getHora()) >0)
				j--;
			if(i<j) {
				aux = v[i].copia();
				v[i] = v[j].copia();
				v[j] = aux.copia();
			}
		}
		v[izq] = v[j].copia();
		v[j] = pivote.copia();
		
		if(izq < j-1) 
			QuickSortHora(v, izq, j-1);
		if(j+1 < der)
			QuickSortHora(v, j+1, der);
	}

	@Override
	public Node getPrimer() {
		// TODO Auto-generated method stub
		return null;
	}
}
