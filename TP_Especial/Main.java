package TP_Especial;

public class Main {

	public static void main(String[] args) {
		Aeropuerto A_Ezeiza = new Aeropuerto("a1","ARG","Ezeiza");
		Aeropuerto A_Calafate = new Aeropuerto("a2", null, null);
		Aeropuerto A_Logan = new Aeropuerto("a3", null, null);
		Aeropuerto A_Kennedy = new Aeropuerto("a4", null, null);
		Aeropuerto A_Pucon = new Aeropuerto("a5", null, null);
		Aeropuerto A_Benitez = new Aeropuerto("a6", null, null);
		Aeropuerto A_Elprat = new Aeropuerto("a7", null, null);
		Aerolinea a1 = new Aerolinea ("a1",15);
		Aerolinea a2 = new Aerolinea ("a2",131);
		Reserva res1 = new Reserva ();
		res1.setOrigen(A_Ezeiza);
		res1.setDestino(A_Calafate);
		res1.setNombreAerolinea("a1");
		res1.setAsientos(12);
		Ruta r1 = new Ruta();
		r1.setOrigen(A_Ezeiza);
		r1.setDestino(A_Calafate);
		r1.setAerolinea(a1);
		Ruta r2 = new Ruta();
		r2.setOrigen(A_Calafate);
		r2.setDestino(A_Logan);
		r2.setAerolinea(a2);
		A_Ezeiza.setRuta(r1);
		A_Calafate.setRuta(r2);
		Sistema s = new Sistema();
		
		s.setAeropuerto(A_Ezeiza);
		s.setAeropuerto(A_Calafate);
		s.setAeropuerto(A_Logan);
		s.setReserva(res1);
		s.vuelo_directo(A_Calafate, A_Logan, "a2");

	}

}
