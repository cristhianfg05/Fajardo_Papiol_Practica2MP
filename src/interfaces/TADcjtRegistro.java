package interfaces;

import Dades.Registro;

public interface TADcjtRegistro {
	boolean afegirRegistro(Registro r);
	boolean eliminarRegistro(Registro r);
	int capacitatLlista();
}
