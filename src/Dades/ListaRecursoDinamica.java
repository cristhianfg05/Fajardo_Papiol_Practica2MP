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
		Node aux =primer;
		if (aux==null) 
			primer=new Node(r);
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
		while (aux != null && hiEs) {
			if (aux.getR() == r) {
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
		while (!trobat && i < numElem) {
			int j = 0;
			while (!trobat && j < primer.getR().getNumVisita()) {
				if (primer.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
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
		for (int i = 0; i < numElem; i++) {
			for (int j = 0; j < primer.getR().getNumVisita(); j++) {
				if (primer.getR().getListaVisita()[j].getData().esIgual(d)) {
					aux[c] = primer.getR().getListaVisita()[j].getAliesAlum();
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
		for (int i = 0; i < numElem; i++) {
			for (int j = 0; j < primer.getR().getNumVisita(); j++) {
				if (primer.getR().getListaVisita()[j].getData().esDataInferiorOigual(d2)
						&& !(primer.getR().getListaVisita()[j].getData().esDataInferiorOigual(d1))) {
					aux[c] = primer.getR().getListaVisita()[j].getAliesAlum();
					c++;
				}
			}
		}
		return aux;
	}

	@Override
	public Recurso[] ConsultarRecursAlumne(String alum) {
		Recurso[] recursos = new Recurso[numElem];
		int c = 0;
		for (int i = 0; i < numElem; i++) {
			int j = 0;
			boolean trobat = false;
			while (j < primer.getR().getNumVisita() && !trobat) {
				if (primer.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alum)) {
					recursos[c] = primer.getR();
					c++;
					trobat = true;
				}
				j++;
			}
		}
		return recursos;
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
		for (int i = 0; i < numElem; i++) {
			for (int j = 0; j < primer.getR().getNumVisita(); j++) {
				if (primer.getR().getListaVisita()[j].getData().esIgual(d)) {
					primer.getR().getListaVisita()[j] = primer.getR().getListaVisita()[primer.getR().getNumVisita()- 1];
					r.setNumVisita(r.getNumVisita()-1);
					c++;
				}
			}
		}
		return c > 0;
	}

	@Override
	public String[] LlistatUserConsultaRecurs(String recurs) {
		String alum[]= new String [100];
		int i=0;
		boolean trobat=false;
		while (i<numElem && !trobat) {
			if (primer.getR().getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else {
				i++;
			}
		}
		for (int j=0; j<primer.getR().getNumVisita(); j++) {
			alum[j]= primer.getR().getListaVisita()[j].getAliesAlum();
		}
		return alum;
	}

	@Override
	public String[] LlistatUserConsultaRecursData(String recurs, Data d) {
		String alum[]=new String[100];
		int i=0;
		boolean trobat=false;
		while (i < numElem && !trobat) {
			if (primer.getR().getNombre().equalsIgnoreCase(recurs)) {
				trobat = true;
			} else {
				i++;
			}
		}
		int c=0;
		for (int j=0; j<primer.getR().getNumVisita(); j++) {
			if (primer.getR().getListaVisita()[j].getData().esIgual(d)) {
				alum[c]= primer.getR().getListaVisita()[j].getAliesAlum();
				c++;
			}
		}
		return alum;
	}

	@Override
	public Recurso mesConsultat() {
		Recurso mesConsultat = null;
		int mesConsultatNum = -1;
		for (int i=0; i<numElem; i++) {
			if (primer.getR().getNumVisita() > mesConsultatNum) {
				mesConsultatNum=primer.getR().getNumVisita();
				mesConsultat=primer.getR().copia();
			}
		}
		return mesConsultat;
	}

	@Override
	public Recurso[] LlistaRecursosConsultatsAlies(String alies) {
		Recurso [] recursos= new Recurso [100];
		int c=0;
		for (int i=0; i< numElem; i++) {
			int j=0;
			boolean trobat=false;
			while (j<primer.getR().getNumVisita() && !trobat) {
				if (primer.getR().getListaVisita()[j].getAliesAlum().equalsIgnoreCase(alies)) {
					trobat = true;
					recursos[c]=primer.getR();
					c++;
				} else {
					j++;
				}
				}
			}		
		return recursos;
	}
	public String toString() {
		String concat="";
		for (int i = 0; i < numElem; i++) {
			concat = concat + primer.getR().toString()+"\n";
		}
		return "ListaRecursoEstatica [listaRecurso=\n" + concat + ", numElem=" + numElem
				+ "]";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean afegirVisita(String r, Visita v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void QuickSortHora(Visita[] v, int izq, int der) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void QuickSortData(Visita[] v, int izq, int der) {
		// TODO Auto-generated method stub
		
	}
	
}
