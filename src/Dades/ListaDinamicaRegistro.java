package Dades;

import java.util.ArrayList;
import java.util.List;

public class ListaDinamicaRegistro implements interfaces.TADcjtRegistro{
	List <Registro> list = new ArrayList<Registro>();

	@Override
	public boolean afegirRegistro(Registro r) {
		return list.add(r);
	}

	@Override
	public boolean eliminarRegistro(Registro r) {
		return list.remove(r);
	}

	@Override
	public int capacitatLlista() {
		return list.size();
	}
}
