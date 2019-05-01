package progTPE;

public class Main {

	public static void main(String[] args) {
		Aeropuerto A_Ezeiza = new Aeropuerto("a1","ARG","Ezeiza");
		Aeropuerto A_Calafate = new Aeropuerto("a2", null, null);
		Aeropuerto A_Logan = new Aeropuerto("a3", null, null);
		Aeropuerto A_Kennedy = new Aeropuerto("a4", null, null);
		Aeropuerto A_Pucon = new Aeropuerto("a5", null, null);
		Aeropuerto A_Benitez = new Aeropuerto("a6", null, null);
		Aeropuerto A_Elprat = new Aeropuerto("a7", null, null);
		Ruta r1 = new Ruta();
		r1.setOrigen(A_Ezeiza);
		r1.setDestino(A_Calafate);
		r1.setAerolinea("hola");
		Ruta r2 = new Ruta();
		r2.setOrigen(A_Calafate);
		r2.setDestino(A_Logan);
		r2.setAerolinea("hola");
		A_Ezeiza.setRuta(r1);
		A_Calafate.setRuta(r2);
		Sistema s = new Sistema();
		s.setAeropuerto(A_Ezeiza);
		s.setAeropuerto(A_Calafate);
		s.setAeropuerto(A_Logan);
		s.vuelo_directo(A_Calafate, A_Logan, "hola");

	}

}
