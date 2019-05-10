package TP_Especial;

import java.util.Vector;

public class Aeropuerto {
private String Nombre;
private String Pais;
private String Ciudad;
private Vector<Ruta> Rutas = new Vector<>();
private String Color;
private String Estado;


public Aeropuerto (String Nombre, String Pais, String Ciudad) {
	this.setNombre(Nombre);
	this.Pais = Pais;
	this.Ciudad = Ciudad;
}

public void setRuta(Ruta a){
	Rutas.add(a);
}

public Vector<Ruta> getRutas(){
	return Rutas;
}

public String getColor() {
	return Color;
}
public void setColor(String color) {
	Color = color;
}

public String getEstado() {
	return Estado;
}

public void setEstado(String estado) {
	Estado = estado;
}

public String getNombre() {
	return Nombre;
}

public void setNombre(String nombre) {
	Nombre = nombre;
}
}
