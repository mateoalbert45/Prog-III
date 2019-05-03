package TP_Especial;

import java.util.Vector;

public class Ruta {
	private Aeropuerto Origen;
	private Aeropuerto Destino;
	private int Kilometros;
	private boolean Cabotaje;
	private Vector<Aerolinea> Aerolineas = new Vector<>();
	
	
	
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
	public Vector<Aerolinea> getAerolineas(){
		return Aerolineas;
	}
	public boolean contiene(String a) {
		return Aerolineas.contains(a);
	}
	
	
	public int cant_pasajes(String a) {
		for(int i=0;i<Aerolineas.size();i++) {
			Aerolinea aux = Aerolineas.elementAt(i);
			//System.out.println("ndeah");
			if(aux.NombreIgual(a)) {
			//	System.out.println(aux.GetPasajes());

				return aux.GetPasajes();
			}
			
		}
		return -1;
	}
	public int getKilometros() {
		return Kilometros;
	}
	public void setKilometros(int kilometros) {
		Kilometros = kilometros;
	}
	public void setAerolinea(Aerolinea a){
		Aerolineas.add(a);
	}
}
