package progTPE;

import java.util.Vector;

public class Aeropuerto {
private String Nombre;
private String Ciudad;
private String Pais;
private Vector<Ruta> Rutas = new Vector<>();
private String Color;
private String Estado;


public Aeropuerto (String Nombre, String Ciudad,String Pais) {
	this.setNombre(Nombre);
	this.setCiudad(Ciudad);
	this.setPais(Pais);
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

public String getPais() {
	return Pais;
}

public void setPais(String pais) {
	Pais = pais;
}

public String getCiudad() {
	return Ciudad;
}

public void setCiudad(String ciudad) {
	Ciudad = ciudad;
}
}
