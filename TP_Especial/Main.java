package TP_Especial;

public class Main {
	//CAMBIAR Cant_Pasajes_Disponibles  PARA QUE LE PASE SOLAMENTE LA RUTA Y  LA CANTIDAD Y DESPUES EN RESRVAS CHEQUEO SEGÚN LA CANTIDAD DE AEROPUERTOS QUE TENGO
//SI NO ME QUEDA MAL PARA HACER EL SERVICIO 3



		public void vuelo_directo_pais_a_otro(String país_origen, String país_destino) {
			for (int i = 0; i < Aeropuertos().size(); i++) {
				Aeropuerto a = Aeropuertos().elementAt(i);
				if (a.getPais().equals(país_origen)) {
for (int i = 0; i < a.getrutas().size(); i++) {
                   Ruta r = a.getRutas().elementAt(i);
	                     If(r.getrutas().contienepaisdestino(país_destino))
If(Cant_Pasajes_Disponibles(r, aerolinea, aux)>0){
                       System.out.println("país origen” + r.getpasorigen() + “  país destino” r.getpaisdestino());

{
				//int aux = r.cant_pasajes(aerolinea);
					


if (aux >= 0) {
						System.out.println("hola");
	
						System.out.println(r.getKilometros());
						System.out.println(Cant_Pasajes_Disponibles(r, aerolinea, aux));
					}
	
				}
			}
		}
			


	public static void main(String[] args) {
		Aeropuerto A_Ezeiza = new Aeropuerto("Ezeiza","ARG","Ezeiza");
		Aeropuerto A_Calafate = new Aeropuerto("Calafate", null, null);
		Aeropuerto A_Logan = new Aeropuerto("Logan", null, null);
		Aeropuerto A_Kennedy = new Aeropuerto("Kennedy", null, null);
		Aeropuerto A_Pucon = new Aeropuerto("Pucon", null, null);
		Aeropuerto A_Benitez = new Aeropuerto("Benitez", null, null);
		Aeropuerto A_Elprat = new Aeropuerto("Elprat", null, null);
		
		Aerolinea a1 = new Aerolinea ("a1",15);
		Aerolinea a2 = new Aerolinea ("a2",131);
		Aerolinea a3 = new Aerolinea ("a3",131);

		
		Reserva res1 = new Reserva ();
		res1.setOrigen(A_Ezeiza);
		res1.setDestino(A_Calafate);
		res1.setNombreAerolinea("a1");
		res1.setAsientos(12);
		
		Ruta r1 = new Ruta(A_Ezeiza,A_Calafate,1,true);
		r1.setOrigen(A_Ezeiza);
		r1.setDestino(A_Calafate);
		r1.setKilometros(1);
		r1.setAerolinea(a1);
		Ruta r2 = new Ruta(A_Calafate,A_Logan,1,true);
		r2.setAerolinea(a1);
		Ruta r3 = new Ruta(A_Logan,A_Kennedy,1,true);
		r3.setAerolinea(a1);
		Ruta r4 = new Ruta(A_Kennedy,A_Calafate,1,true);
		r4.setAerolinea(a1);
		Ruta r5 = new Ruta(A_Ezeiza,A_Elprat,10,true);
		r5.setAerolinea(a1);

		Ruta r6 = new Ruta(A_Calafate,A_Elprat,1,true);
		r6.setAerolinea(a2);
		Ruta r7 = new Ruta(A_Ezeiza,A_Benitez,1,true);
		r7.setAerolinea(a2);
		Ruta r8 = new Ruta(A_Elprat,A_Benitez,1,true);
		r8.setAerolinea(a2);

		
		A_Ezeiza.setRuta(r1);
		A_Calafate.setRuta(r2);
		A_Logan.setRuta(r3);
		A_Kennedy.setRuta(r4);
		A_Ezeiza.setRuta(r5);
		A_Calafate.setRuta(r6);
		A_Ezeiza.setRuta(r7);
		A_Elprat.setRuta(r8);

		

		
		Sistema s = new Sistema();
		
		s.setAeropuerto(A_Ezeiza);
		s.setAeropuerto(A_Calafate);
		s.setAeropuerto(A_Logan);
		s.setAeropuerto(A_Kennedy);
		s.setAeropuerto(A_Elprat);
		s.setAeropuerto(A_Benitez);

		s.setReserva(res1);
		//s.vuelo_directo(A_Calafate, A_Logan, "a2");
		s.dfs(A_Ezeiza, A_Benitez, a3);
	}
	
	



}
