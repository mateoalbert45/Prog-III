package progTPE;

public class Reserva {
private Aeropuerto Origen;
private Aeropuerto Destino;
private String Aerolinea;
private int Asientos_Reservados;


public int es_igual(Aeropuerto o, Aeropuerto d, String a, int cantidad) {
	//System.out.println(o.getNombre());
	//System.out.println(d.getNombre());
	//System.out.println(a);
	//System.out.println(cantidad);
	//System.out.println("ndeah  " + Origen.getNombre());
	//System.out.println("ddssd   "+Destino.getNombre());
	//System.out.println("dsadasds ndea  "+Aerolinea);
	if(Origen.equals(o) && Destino.equals(d) && Aerolinea.equals(a)) {
		//System.out.println("asdasdsad");
		return  cantidad-Asientos_Reservados;
	}
	//System.out.println("d");

	return -1;
	
}

public void setOrigen(Aeropuerto origen) {
	Origen = origen;
}
public void setDestino(Aeropuerto destino) {
	Destino = destino;
}
public void setNombreAerolinea(String nombre) {
	Aerolinea = nombre;
}
public void setAsientos(int num) {
	Asientos_Reservados = num;
}


}
