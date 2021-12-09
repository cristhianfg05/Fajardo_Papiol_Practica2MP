package interfaces;

import Dades.Usuari;

public interface TADcjtUsuario {
	boolean afegirUser(Usuari u);
	boolean eliminarUser(Usuari u);
	int capacitatLlista();
}
