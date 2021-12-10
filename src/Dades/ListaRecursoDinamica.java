package Dades;

import java.util.ArrayList;

public class ListaRecursoDinamica {
	private ArrayList<Recurso> listaRecursos = new ArrayList<Recurso>();
	
	
	public boolean afegirRecurs(Recurso r) {
		return listaRecursos.add(r);
	}
}
