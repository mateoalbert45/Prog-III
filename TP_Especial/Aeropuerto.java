package TP_Especial;

import java.util.Vector;

public class Aeropuerto {
private String Nombre;
private String Pais;
private String Ciudad;
private Vector<Ruta> Rutas = new Vector<>();
private String Color;

public Aeropuerto (String Nombre, String Pais, String Ciudad) {
	this.Nombre = Nombre;
	this.Pais = Pais;
	this.Ciudad = Ciudad;
}

public void setRuta(Ruta a){
	Rutas.add(a);
}

public Vector<Ruta> getRuta(){
	return Rutas;
}

public String getColor() {
	return Color;
}
public void setColor(String color) {
	Color = color;
}
}
