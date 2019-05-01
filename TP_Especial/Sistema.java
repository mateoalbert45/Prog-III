package progTPE;

import java.util.Vector;

public class Sistema {
	private Vector<Aeropuerto> Aeropuertos = new Vector<>();

	
	public void setAeropuerto(Aeropuerto a){
		Aeropuertos.add(a);
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
				System.out.println("ndeasfafs");
				if(r.contiene(aerolinea)) {
					int asientos_disponibles = cant_asientos(r,aerolinea);
					System.out.println(asientos_disponibles);
					System.out.println(r.getKilometros());
				}
			}
		}
	}
	
	public int cant_asientos(Ruta r, String aerolinea) {
		return 0;
		
	}
}
