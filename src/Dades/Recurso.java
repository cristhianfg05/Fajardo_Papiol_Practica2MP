package Dades;

public class Recurso {
	private int codigo;
	private String nombre;
	private Visita [] listaVisita;
	private int numVisita;
	
	public Recurso (int codi, String nom) {
		this.codigo = codi;
		this.nombre = nom;
		this.listaVisita = new Visita[100];
		this.numVisita = 0;
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
}
