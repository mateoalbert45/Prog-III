package progTPE;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//
public class Main {
//
	public static void main(String[] args) {
		Sistema s = new Sistema();
		leerArchivos(s);
		s.holaxd();
		
//		Aeropuerto A_Ezeiza = new Aeropuerto("Ezeiza","ARG","Ezeiza");
//		Aeropuerto A_Calafate = new Aeropuerto("Calafate", "ARG", null);
//		Aeropuerto A_Logan = new Aeropuerto("Logan", "USA", null);
//		Aeropuerto A_Kennedy = new Aeropuerto("Kennedy", "USA", null);
//		Aeropuerto A_Pucon = new Aeropuerto("Pucon", "CHI", null);
//		Aeropuerto A_Benitez = new Aeropuerto("Benitez", "CHI", null);
//		Aeropuerto A_Elprat = new Aeropuerto("Elprat", "ESP", null);
//		
//		Aerolinea a1 = new Aerolinea ("a1",11);
//		Aerolinea a2 = new Aerolinea ("a2",12);
//		Aerolinea a3 = new Aerolinea ("a3",13);
//		Aerolinea a4 = new Aerolinea ("a4",14);
//
//		
//		Reserva res1 = new Reserva ();
//		res1.setOrigen(A_Ezeiza);
//		res1.setDestino(A_Elprat);
//		res1.setNombreAerolinea("a1");
//		res1.setAsientos(11);
//		
//		Reserva res2 = new Reserva ();
//		res2.setOrigen(A_Ezeiza);
//		res2.setDestino(A_Elprat);
//		res2.setNombreAerolinea("a2");
//		res2.setAsientos(2);
//		
//		Reserva res3 = new Reserva ();
//		res3.setOrigen(A_Calafate);
//		res3.setDestino(A_Elprat);
//		res3.setNombreAerolinea("a3");
//		res3.setAsientos(10);
//		
//		Ruta r1 = new Ruta(A_Ezeiza,A_Calafate,5,true); //
//		//r1.setOrigen(A_Ezeiza);
//		//r1.setDestino(A_Calafate);
//		//r1.setKilometros(1);
//		r1.setAerolinea(a3);
//		r1.setAerolinea(a2);
//
//		Ruta r2 = new Ruta(A_Calafate,A_Logan,1,true);
//		r2.setAerolinea(a1);
//		Ruta r3 = new Ruta(A_Logan,A_Kennedy,1,true);
//		r3.setAerolinea(a1);
//		Ruta r4 = new Ruta(A_Kennedy,A_Calafate,1,true);
//		r4.setAerolinea(a1);
//		Ruta r5 = new Ruta(A_Ezeiza,A_Elprat,10,true);
//		r5.setAerolinea(a1);
//		r5.setAerolinea(a2);
//
//
//		Ruta r6 = new Ruta(A_Calafate,A_Elprat,3,true);  
//		r6.setAerolinea(a3);
//		r6.setAerolinea(a1);
//
//		Ruta r7 = new Ruta(A_Ezeiza,A_Benitez,1,true);
//		r7.setAerolinea(a2);
//		r7.setAerolinea(a3);
//
//		Ruta r8 = new Ruta(A_Elprat,A_Benitez,4,true);  
//		r8.setAerolinea(a2);
//
//		
//		A_Ezeiza.setRuta(r1);
//		A_Calafate.setRuta(r2);
//		A_Logan.setRuta(r3);
//		A_Kennedy.setRuta(r4);
//		A_Ezeiza.setRuta(r5);
//		A_Calafate.setRuta(r6);
//		A_Ezeiza.setRuta(r7);
//		A_Elprat.setRuta(r8);
//
//		
//
//		
//		Sistema s = new Sistema();
//		
//		s.setAeropuerto(A_Ezeiza);
//		s.setAeropuerto(A_Calafate);
//		s.setAeropuerto(A_Logan);
//		s.setAeropuerto(A_Kennedy);
//		s.setAeropuerto(A_Elprat);
//		s.setAeropuerto(A_Benitez);
//
//		s.setReserva(res1);
//		s.setReserva(res2);
//		s.setReserva(res3);
//
//
//		//s.vuelo_directo(A_Calafate, A_Logan, "a2");
//		//s.dfs(A_Ezeiza, A_Benitez, a3);
//		s.vuelo_directo_pais_a_otro("ARG", "ESP");
	}
//	
//	
//
//
//
	
	
	public static void leerArchivos(Sistema s) {

		// CAMBIAR RUTAS SEGUN LA PC
		String csvAeropuertos = "src/progTPE/Informacion para setear/Aeropuertos.csv";
		//String csvRutas = "src/sistema/dataset/Rutas.csv";
		//String csvReservas = "src/sistema/dataset/Reservas.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvAeropuertos))) {

			while ((line = br.readLine()) != null) {

				String[] aeropuertos = line.split(cvsSplitBy);

				Aeropuerto aeropuerto = new Aeropuerto(aeropuertos[0], aeropuertos[1], aeropuertos[2]);
				s.setAeropuerto(aeropuerto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
