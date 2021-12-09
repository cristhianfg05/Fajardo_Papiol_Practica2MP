package Dades;

public class Recurso {
	private int codigo;
	private String nombre;
	private ListaDinamicaRegistro listD;
	private ListaEstaticaRegistro listE;
	
	public void eliminarConsultasDinamica() {
		for (int i = 0; i < listD.capacitatLlista(); i++) {
			listD.eliminarRegistro(this);
		}
	}
}
