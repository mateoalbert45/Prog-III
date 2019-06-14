package progTPE;


public class Camino_servicio3 {
	private Ruta Ruta;
	private int Cant_pasajes;
	private String Aerolinea;
	
	
	public Camino_servicio3(Ruta r,int c, String a) {
		Ruta  =r;
		Cant_pasajes = c;
		Aerolinea = a;
	}
	
	public Ruta getRuta() {
		return Ruta;
	}

	public int getCant_pasajes() {
		return Cant_pasajes;
	}

	public String getAerolinea() {
		return Aerolinea;
	}

}
