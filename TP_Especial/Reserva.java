package TP_Especial;

public class Reserva {
private Aeropuerto Origen;
private Aeropuerto Destino;
private String Aerolinea;
private int Asientos_Reservados;


public int es_igual(Aeropuerto o, Aeropuerto d, String a, int cantidad) {
	if(Origen.equals(o) && Destino.equals(d) && Aerolinea.equals(a)) {
		return  cantidad-Asientos_Reservados;
	}
	return cantidad;
	
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
