package Dades;

import interfaces.TADcjtRecurso;

public class ListaRecursoDinamica implements TADcjtRecurso {

	private Node primer;
	private int numElem;

	public ListaRecursoDinamica() {
		primer = null;
		numElem = 0;
	}

	public boolean afegirRecurs(Recurso r) { // mètode que afegeix un recurs
		if (!pertany(r)) {
			Node aux = primer;
			if (aux == null)
				primer = new Node(r);
			else {
				while (aux.getSeguent() != null)
					aux = aux.getSeguent();
				aux.setSeguent(new Node(r));
			}
			numElem++;
			return true;
		} else
			return false;
	}

	private boolean pertany(Recurso r) { // mètode que busca si existeix el Recurs
		boolean hiEs = false;
		Node aux = primer;
		while (aux != null && !hiEs) {
			if (aux.getR().getNombre().equals(r.getNombre())) {
				hiEs = true;
			} else {
				aux = aux.getSeguent();
			}
		}
		return hiEs;
	}

	@Override
	public boolean consultarAlumne(String alum) {
		int i = 0;
		boolean trobat = false;
		Node aux = primer;
		while (!trobat && i < numElem) {
			int j = 0;
			while (!trobat && j < aux.getR().getNumVisita()) {
				if (aux.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
					trobat = true;
				}
				j++;

			}
			aux = aux.getSeguent();
			i++;
		}
		return trobat;
	}

	@Override
	public String[] llistatUsers(Data d) {
		String[] aux = new String[10000];
		int c = 0;
		Node nodeAux = primer;
		for (int i = 0; i < numElem; i++) {
			for (int j = 0; j < nodeAux.getR().getNumVisita(); j++) {
				if (nodeAux.getR().getListaVisita()[j].getData().esIgual(d)) {
					aux[c] = nodeAux.getR().getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
			nodeAux = nodeAux.getSeguent();
		}
		String[] s = new String[c];
		for (int i = 0; i < c; i++) {
			s[i] = aux[i];
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

		String[] aux = new String[10000];
		int c = 0;
		Node nodeAux = primer;
		for (int i = 0; i < numElem; i++) {
			for (int j = 0; j < nodeAux.getR().getNumVisita(); j++) {
				if (nodeAux.getR().getListaVisita()[j].getData().esDataInferiorOigual(d2)
						&& !(nodeAux.getR().getListaVisita()[j].getData().esDataInferiorOigual(d1))) {
					aux[c] = nodeAux.getR().getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
			nodeAux = nodeAux.getSeguent();
		}
		String[] s = new String[c];
		for (int i = 0; i < c; i++) {
			s[i] = aux[i];
		}
		return s;
	}

	@Override
	public Recurso[] ConsultarRecursAlumne(String alum) {
		Recurso[] recursos = new Recurso[numElem];
		int c = 0;
		Node nodeAux = primer;
		for (int i = 0; i < numElem; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < nodeAux.getR().getNumVisita() && !trobat) {
				if (nodeAux.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
					recursos[c] = nodeAux.getR();
					c++;
					trobat = true;
				}
				j++;
			}
			nodeAux =nodeAux.getSeguent();
		}
		Recurso[] r = new Recurso[c];
		for (int i = 0; i < c; i++) {
			r[i] = recursos[i];
		}
		return r;
	}

	@Override
	public boolean EsborrarDadesConsulta(Recurso r) {
		int i = 0;
		Node aux = primer;
		boolean trobat = false;
		while(i<numElem && !trobat) {
			if(aux.getR().getNombre().equalsIgnoreCase(r.getNombre())) {
				trobat = true;
			}else {
				i++;
				aux = aux.getSeguent();
			}
		}
		if(trobat) {
			aux.getR().setListaVisita(new Visita[1000]);
			aux.getR().setNumVisita(0);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean EsborrarDadesConsultaData(Recurso r, Data d) {
		int i = 0;
		Node nodeAux = primer;
		boolean trobat = false;
		Node aux = primer;
		while(i<numElem && !trobat) {
			if(aux.getR().getNombre().equalsIgnoreCase(r.getNombre())) {
				trobat = true;
			}else
				i++;
		}
		
		int j = 0;
		boolean borrado = false;
		while(j<aux.getR().getNumVisita()) {
			if(aux.getR().getListaVisita()[j].getData().esIgual(d)) {
				Visita [] lista = aux.getR().getListaVisita();
				lista[j] = aux.getR().getListaVisita()[aux.getR().getNumVisita()-1];
				aux.getR().setListaVisita(lista);
				aux.getR().setNumVisita(aux.getR().getNumVisita()-1);
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
		Node nodeAux = primer;
		while (i < numElem && !trobat) {
			if (nodeAux.getR().getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else {
				nodeAux = nodeAux.getSeguent();
				i++;
			}
		}
		int j = 0;
		for (; j < nodeAux.getR().getNumVisita(); j++) {
			alum[j] = nodeAux.getR().getListaVisita()[j].getAliesAlum();
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
		Node nodeAux = primer;
		while (i < numElem && !trobat) {
			if (nodeAux.getR().getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else {
				i++;
				nodeAux=nodeAux.getSeguent();
			}
		}
		int c = 0;
		for (int j = 0; j < nodeAux.getR().getNumVisita(); j++) {
			if (nodeAux.getR().getListaVisita()[j].getData().esIgual(d)) {
				alum[c] = nodeAux.getR().getListaVisita()[j].getAliesAlum();
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
		Node nodeAux = primer;
		for (int i = 0; i < numElem; i++) {
			if (nodeAux.getR().getNumVisita() > mesConsultatNum) {
				mesConsultatNum = nodeAux.getR().getNumVisita();
				mesConsultat = nodeAux.getR().copia();
			}
			nodeAux = nodeAux.getSeguent();
		}
		return mesConsultat;
	}

	@Override
	public Recurso[] LlistaRecursosConsultatsAlies(String alies) {
		Recurso[] recursos = new Recurso[10000];
		int c = 0;
		Node nodeAux = primer;
		for (int i = 0; i < numElem; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < nodeAux.getR().getNumVisita() && !trobat) {
				if (nodeAux.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alies)) {
					trobat = true;
					recursos[c] = nodeAux.getR();
					c++;
				} else {
					j++;
				}
			}
			nodeAux = nodeAux.getSeguent();
		}
		Recurso[] s = new Recurso[c];
		for (int i = 0; i < c; i++) {
			s[i] = recursos[i];
		}
		return s;
	}

	public String toString() {
		String concat = "";
		Node aux = primer;
		for (int i = 0; i < numElem; i++) {
			concat = concat + aux.getR().toString() + "\n";
			aux = aux.getSeguent();
		}
		return "ListaRecursoEstatica [listaRecurso=\n" + concat + ", numElem=" + numElem + "]";
	}

	public Node getPrimer() {
		return primer;
	}

	public void setPrimer(Node primer) {
		this.primer = primer;
	}

	@Override
	public int getNumRecursos() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Recurso[] getListaRecurso() {
		Recurso[] r = new Recurso[numElem];
		int c = 0;
		Node aux = primer;
		for (int i = 0; i < numElem; i++) {
			r[i] = aux.getR().copia();
			aux = aux.getSeguent();
			c++;
		}
		Recurso[] r2 = new Recurso[c];
		for (int i = 0; i < r2.length; i++) {
			r2[i] = r[i].copia();
		}
		return r2;
	}

	@Override
	public boolean afegirVisita(String r, Visita v) {
		boolean trobat=false;
        boolean afegit=false;
        Node nodeAux = primer;
        int i = 0;
        while (i < numElem && !trobat) {
            if (nodeAux.getR().getNombre().equalsIgnoreCase(r)) {
                afegit=nodeAux.getR().afegirVisita(v);
                trobat=true;
            } else {
            	i++;
            	nodeAux=nodeAux.getSeguent();
            }
        }
        return afegit;
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

	public int getNumElem() {

		return numElem;
	}

}
