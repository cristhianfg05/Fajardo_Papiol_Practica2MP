package Dades;

import java.util.Arrays;

public class Recurso {
	private int codigo;
	private String nombre;
	private Visita[] listaVisita;
	private int numVisita;

	public Recurso(int codi, String nom) {
		this.codigo = codi;
		this.nombre = nom;
		this.listaVisita = new Visita[1000];
		this.numVisita = 0;
	}

	public Recurso(int codi, String nom, Visita[] lista, int numV) {
		this.codigo = codi;
		this.nombre = nom;
		this.listaVisita = lista;
		this.numVisita = numV;
	}

	public void afegirVisita (Visita v) {
		if(!(numVisita == listaVisita.length)) {
			listaVisita[numVisita] = v;
			numVisita++;
		}
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Visita[] getListaVisita() {
		return listaVisita;
	}

	public void setListaVisita(Visita[] listaVisita) {
		this.listaVisita = listaVisita;
	}

	public int getNumVisita() {
		return numVisita;
	}

	public void setNumVisita(int num) {
		this.numVisita = num;
	}

	public Recurso copia() {
		return new Recurso(this.codigo, this.nombre, this.listaVisita, this.numVisita);

	}

	@Override
	public String toString() {
		String concat = " ";
		for (int i = 0; i < numVisita; i++) {
			concat = concat + "Visita: "+listaVisita[i].toString();
		}
		return "Recurso [codigo=" + codigo + ", nombre=" + nombre + ", listaVisita=" + concat + ", numVisita="
				+ numVisita + "]";
	}

}
