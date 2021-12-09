package Dades;

import java.util.ArrayList;
import java.util.List;

public class ListaDinamicaUsuario implements interfaces.TADcjtUsuario{
	List <Usuari> list = new ArrayList<Usuari>();

	@Override
	public boolean afegirUser(Usuari u) {
		return list.add(u);
	}

	@Override
	public boolean eliminarUser(Usuari u) {
		return list.remove(u);
	}

	@Override
	public int capacitatLlista() {
		return list.size();
	}
}
