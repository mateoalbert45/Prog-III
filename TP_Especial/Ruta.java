package progTPE;

import java.util.Vector;

public class Ruta {
	private Aeropuerto Origen;
	private Aeropuerto Destino;
	private int Kilometros;
	private boolean Cabotaje;
	private Vector<String> Aerolineas = new Vector<>();
	
	
	
	public Aeropuerto getOrigen() {
		return Origen;
	}
	public void setOrigen(Aeropuerto origen) {
		Origen = origen;
	}
	public Aeropuerto getDestino() {
		return Destino;
	}
	public void setDestino(Aeropuerto destino) {
		Destino = destino;
	}
	public Vector<String> getAerolineas(){
		return Aerolineas;
	}
	public boolean contiene(String a) {
		return Aerolineas.contains(a);
	}
	public int getKilometros() {
		return Kilometros;
	}
	public void setKilometros(int kilometros) {
		Kilometros = kilometros;
	}
	public void setAerolinea(String a){
		Aerolineas.add(a);
	}
}
