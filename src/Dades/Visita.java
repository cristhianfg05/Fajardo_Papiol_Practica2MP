package Dades;

import java.sql.Time;

public class Visita {
	private int CodiAlumno;
	private String aliesAlum;
	private Data data;
	private Time hora;
	
	public Visita (int codi, String alies, Data d, Time t ) {
		this.CodiAlumno = codi;
		this.data = d;
		this.hora = t;
		this.aliesAlum = alies;
	}

	public int getCodiAlumno() {
		return CodiAlumno;
	}

	public void setCodiAlumno(int codiAlumno) {
		CodiAlumno = codiAlumno;
	}

	public String getAliesAlum() {
		return aliesAlum;
	}

	public void setAliesAlum(String aliesAlum) {
		this.aliesAlum = aliesAlum;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Visita [CodiAlumno=" + CodiAlumno + ", aliesAlum=" + aliesAlum + ", data=" + data + ", hora=" + hora
				+ "]";
	}

	public Visita copia() {
		return new Visita(this.CodiAlumno,this.aliesAlum,this.data,this.hora);
	}
	
}
