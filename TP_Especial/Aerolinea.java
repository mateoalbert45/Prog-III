package TP_Especial;

public class Aerolinea {
	private String Nombre;
	private int Pasajes;

public Aerolinea(String n, int p) {
	Nombre=n;
	Pasajes=p;
}
public boolean NombreIgual(String n) {
	return Nombre.equals(n);
}

public int GetPasajes() {
	return Pasajes;
}

public String GetNombre() {
	return Nombre;
}
}
