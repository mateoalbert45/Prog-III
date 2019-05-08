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
	
	

public void dfs(node origen, node objetivo) {
	for(int i =0;i<nodos.size();i++) {
		nodos.elementAt(i).setcolor("blanco");
	}
	int tiempo=0;
			dfs_visit(origen,tiempo,origen,objetivo);
	}


public int dfs_visit(node n,int t,node origen,node objetivo) {
	int tiempo = t+1;
	n.settiempodestino(tiempo);
	
	for(int i=0;i<n.getaristas().size();i++) {
		node aux=n.getaristas().elementAt(i).getdestination();
		
		if(aux.getcolor().equals("blanco")) {

			aux.setcolor("amarillo");
			System.out.println("--- " + n.getinfo());
				 tiempo = dfs_visit(aux,tiempo,origen,objetivo);
			aux.setcolor("blanco");
			if(aux.equals(objetivo)){
				System.out.println("camino encontrado");
			}
		}
	}
	tiempo++;
	n.settiempofinal(tiempo);

	return tiempo;
}

}
