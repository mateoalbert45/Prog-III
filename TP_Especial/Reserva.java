package progTPE;

public class Reserva {
private Aeropuerto Origen;
private Aeropuerto Destino;
private String Aerolinea;
private int Asientos_Reservados;


public Reserva(Aeropuerto o, Aeropuerto d, String a, int asre) {
	Origen = o;
	Destino = d;
	Aerolinea = a;
	Asientos_Reservados = asre;
	
}

public boolean es_igual(Aeropuerto o, Aeropuerto d, String a) {
	//System.out.println(o.getNombre());
	//System.out.println(d.getNombre());
	//System.out.println(a);
	//System.out.println(cantidad);
	//System.out.println("ndeah  " + Origen.getNombre());
	//System.out.println("ddssd   "+Destino.getNombre());
	//System.out.println("dsadasds ndea  "+Aerolinea);
	if(Origen.equals(o) && Destino.equals(d) && Aerolinea.equals(a)) {
		//System.out.println("asdasdsad");
		return  true;
	}
	//System.out.println("d");

	return false;
	
}
	
public int calcular_pasajes_disponibles(int cantidad){
        return cantidad-Asientos_Reservados;
}
public void setOrigen(Aeropuerto origen) {
	Origen = origen;
}

public Aeropuerto getOrigen() {
	return Origen;
}


public void setDestino(Aeropuerto destino) {
	Destino = destino;
}

public Aeropuerto getDestino() {
	return Destino;
}
public void setNombreAerolinea(String nombre) {
	Aerolinea = nombre;
}


public String getNombreAerolinea() {
	return Aerolinea;
}
public void setAsientos(int num) {
	Asientos_Reservados = num;
}


public int getAsientos() {
	return Asientos_Reservados;
}

}
