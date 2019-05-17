package progTPE;

import java.util.Vector;

public class Ruta {
	private Aeropuerto Origen;
	private Aeropuerto Destino;
	private Double Kilometros;
	private boolean Cabotaje;
	private Vector<Aerolinea> Aerolineas = new Vector<>();
	
	public Ruta (Aeropuerto Origen, Aeropuerto Destino, Double Kilometros, boolean Cabotaje) {
		this.Origen = Origen;
		this.Destino = Destino;
		this.Kilometros = Kilometros;
		this.setCabotaje(Cabotaje);
	}
	
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
	public Double getKilometros() {
		return Kilometros;
	}
	public void setKilometros(Double kilometros) {
		Kilometros = kilometros;
	}
	public void setAerolinea(Aerolinea a){
		Aerolineas.add(a);
	}
	
	public boolean contiene_aerolinea_distinta_a(String a) {
		for(int i=0;i<Aerolineas.size();i++) {
			Aerolinea aux = Aerolineas.elementAt(i);
			if(!(aux.GetNombre().equals(a))) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public String getAerolineas_String(){
		String aux = "";
		for(int i=0;i<Aerolineas.size();i++) {
			 aux += Aerolineas.elementAt(i).GetNombre() + " ";
			
		}
		return aux;
	}

	public boolean getCabotaje() {
		return Cabotaje;
	}

	public void setCabotaje(boolean cabotaje) {
		Cabotaje = cabotaje;
	}
}
