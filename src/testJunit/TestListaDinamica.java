package testJunit;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import Dades.Data;
import Dades.ListaRecursoDinamica;
import Dades.Recurso;
import Dades.Visita;

@TestMethodOrder(OrderAnnotation.class)
class TestListaDinamica {

	private static ListaRecursoDinamica instance = new ListaRecursoDinamica();

	@Test
	@Order(1)
	void testAfegirRecursCorrecto() {
		Recurso prueba = new Recurso(1, "Video MP");
		boolean resultEsp = true;
		boolean result = instance.afegirRecurs(prueba);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(2)
	void testAfegirRecursIncorrecto() {
		Recurso prueba = new Recurso(1, "Video MP");
		boolean resultEsp = false;
		boolean result = instance.afegirRecurs(prueba);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(3)
	void testAfegirVisitaCorrecto() {
		Visita prueba = new Visita(1, "Cristhian", new Data(2, 1, 2000), Time.valueOf("10:05:32"));
		boolean resultEsp = true;
		boolean result = instance.afegirVisita("Video MP", prueba);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(4)
	void testAfegirVisitaIncorrecto() {
		Visita prueba = new Visita(1, "Arnau", new Data(1, 1, 2000), Time.valueOf("10:05:32"));
		boolean resultEsp = false;
		boolean result = instance.afegirVisita("Video Analisis matematico", prueba);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(5)
	void testConsultarAlumneCorrecte() {
		String alum = "Cristhian";
		boolean resultEsp = true;
		boolean result = instance.consultarAlumne(alum);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(6)
	void testConsultarAlumneIncorrecte() {
		String alum = "Arnau";
		boolean resultEsp = false;
		boolean result = instance.consultarAlumne(alum);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(7)
	void testLlistatUsers() {
		Visita prueba = new Visita(1, "Cristhian", new Data(2, 1, 2000), Time.valueOf("10:05:32"));
		for (int i = 0; i < 10; i++) {
			instance.afegirVisita("Video MP", prueba);
		}
		String lista[] = instance.llistatUsers(new Data(2, 1, 2000));
		String listaEsperada[] = { "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian",
				"Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian" };
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < instance.getListaRecurso()[0].getNumVisita(); i++) {
			if (!(lista[i].equalsIgnoreCase(listaEsperada[i])))
				result = false;
		}
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(8)
	void testllistatUsersFranja() {
		String lista[] = instance.llistatUsersFranja(new Data(1, 1, 2000), new Data(5, 2, 2000));
		String listaEsperada[] = { "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian",
				"Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian" };
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < lista.length; i++) {
			if (!(lista[i].equalsIgnoreCase(listaEsperada[i])))
				result = false;
		}
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(9)
	void testConsultarRecursAlumne() {
		instance.afegirRecurs(new Recurso(13, "Video Mates"));
		instance.afegirRecurs(new Recurso(13, "Programacion examen"));
		instance.getListaRecurso()[1]
				.afegirVisita(new Visita(1, "Cristhian", new Data(1, 1, 2000), Time.valueOf("10:05:32")));
		instance.getListaRecurso()[2]
				.afegirVisita(new Visita(1, "Cristhian", new Data(1, 1, 2000), Time.valueOf("10:05:32")));
		Recurso lista[] = instance.ConsultarRecursAlumne("Cristhian");
		Recurso listaEsperada[] = { new Recurso(1, "Video MP"), new Recurso(13, "Video Mates"),
				new Recurso(13, "Programacion examen") };
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < lista.length; i++) {
			if (!(lista[i].getNombre().equals(listaEsperada[i].getNombre())))
				result = false;
		}
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(10)
	void testEsborrarDadesConsulta() {
		boolean resultEsp = true;
		boolean result = instance.EsborrarDadesConsulta(instance.getListaRecurso()[1]);
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(11)
	void testEsborrarDadesConsultaData() {
		boolean resultEsp = true;
		instance.afegirVisita("Programacion examen",
				new Visita(1, "Cristhian", new Data(5, 1, 2000), Time.valueOf("10:05:32")));

		boolean result = instance.EsborrarDadesConsultaData(instance.getListaRecurso()[2], new Data(5, 1, 2000));
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(12)
	void testLlistatUserConsultaRecurs() {
		String lista[] = instance.LlistatUserConsultaRecurs("Video MP");
		String listaEsperada[] = { "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian",
				"Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian" };
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < lista.length; i++) {
			if (!(lista[i].equalsIgnoreCase(listaEsperada[i])))
				result = false;
		}
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(13)
	void testLlistatUserConsultaRecursData() {
		String lista[] = instance.LlistatUserConsultaRecursData("Video MP", new Data(2, 1, 2000));
		String listaEsperada[] = { "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian",
				"Cristhian", "Cristhian", "Cristhian", "Cristhian", "Cristhian" };
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < lista.length; i++) {
			if (!(lista[i].equalsIgnoreCase(listaEsperada[i]))) {
				result = false;
			}

		}
		assertEquals(resultEsp, result);
	}

	@Test
	@Order(14)
	void testMesConsultat() {
		Recurso result = new Recurso(199, "Respuestas examen");
		instance.afegirRecurs(result);
		for (int i = 0; i < 500; i++) {
			instance.afegirVisita("Respuestas examen",
					new Visita(1, "Cristhian", new Data(1, 1, 2000), Time.valueOf("10:05:32")));
		}
		Recurso esperado = instance.mesConsultat().copia();
		boolean esperado2 = true;
		boolean obtenido = result.getNumVisita() == esperado.getNumVisita();
		assertEquals(esperado2, obtenido);
	}

	@Test
	@Order(15)
	void testLlistaRecursosConsultatsAlies() {
		Recurso lista[] = instance.LlistaRecursosConsultatsAlies("Cristhian");
		Recurso listaEsperada[] = { new Recurso(1, "Video MP"), new Recurso(13, "Programacion examen"),
				new Recurso(199, "Respuestas examen") };
		System.out.print(instance);
		boolean resultEsp = true;
		boolean result = true;
		for (int i = 0; i < lista.length; i++) {
			if (!(lista[i].getNombre().equals(listaEsperada[i].getNombre()))) {
				result = false;
			}
			System.out.print(listaEsperada[i].getNombre()+" no es igual a "+lista[i].getNombre());
		}
		assertEquals(resultEsp, result);
	}

}
