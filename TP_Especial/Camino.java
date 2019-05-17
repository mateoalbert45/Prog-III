package progTPE;

import java.util.Vector;

public class Camino {
	private Vector<Ruta> Rutas;
	private int Escalas;
	private double Kilometros;
	
	
	public Camino(Vector<Ruta> r,int e, double k) {
		Rutas  =r;
		Escalas = e;
		Kilometros = k;
	}
	
	public Vector<Ruta> getRutas() {
		return Rutas;
	}
	public void setRuta(Ruta rutas) {
		Rutas.add(rutas);
	}
	public int getEscalas() {
		return Escalas;
	}
	public void setEscalas(int escalas) {
		Escalas = escalas;
	}
	public double getKilometros() {
		return Kilometros;
	}
	public void setKilometros(double kilometros) {
		Kilometros = kilometros;
	}

}
