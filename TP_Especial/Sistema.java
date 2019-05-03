package TP_Especial;

import java.util.Vector;

public class Sistema {
	private Vector<Aeropuerto> Aeropuertos = new Vector<>();
	private Vector<Reserva> Reservas = new Vector<>();

	
	public void setAeropuerto(Aeropuerto a){
		Aeropuertos.add(a);
	}
	
	public void setReserva(Reserva a){
		Reservas.add(a);
	}
	
	public void dfs() {
		for(int i =0;i<Aeropuertos.size();i++) {
			Aeropuertos.elementAt(i).setColor("blanco");
		}
		int tiempo=0;
		for(int i =0;i<Aeropuertos.size();i++) {
			Aeropuerto n = Aeropuertos.elementAt(i);
			if(n.getColor().equals("blanco")) {
				dfs_visit(n,tiempo);
			}
		}
	}

	public int dfs_visit(Aeropuerto n,int t) {
		n.setColor("amarillo");
		int tiempo = t+1;
		//n.settiempodestino(tiempo);
		for(int i=0;i<n.getRuta().size();i++) {
			Aeropuerto aux=n.getRuta().elementAt(i).getDestino();
			if(aux.getColor().equals("blanco")) {
					 tiempo = dfs_visit(aux,tiempo);
			}
		}
		n.setColor("negro");
		//System.out.println(n.getinfo());
		tiempo++;
		//n.settiempofinal(tiempo);
		//System.out.println("--- " + n.gettiempodestino());
		//System.out.println("--- "+n.gettiempofinal());
		return tiempo;
	}
	
	
	public void vuelo_directo(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		for(int i=0; i<origen.getRuta().size();i++) {
			Ruta r = origen.getRuta().elementAt(i);
			if(r.getDestino().equals(destino)) {
				int aux = r.cant_pasajes(aerolinea);
				if(aux>=0) {
					System.out.println("hola");

					System.out.println(r.getKilometros());
					System.out.println(Cant_Pasajes_Disponibles(r,aerolinea,aux));
				}
				
			}
		}
	}
	
	public int Cant_Pasajes_Disponibles(Ruta r, String aerolinea,int cantidad) {
		for(int i=0;i<Reservas.size();i++) {
			return Reservas.elementAt(i).es_igual(r.getOrigen(), r.getDestino(), aerolinea, cantidad);
		}
		
		return cantidad;
		
	}
}
