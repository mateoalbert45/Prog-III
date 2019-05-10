package P3_EJ2;

import java.util.Vector;

public class node {
private Object info;
	//PARA HACER UN GRAFO NO DIRIGIDO NECESITO AGREGAR LA RUTA EN AMBOS NODOS, OSEA AGREGO LA RUTA QUE VA DE "A" a "B"  EN AMBOS NODOS
private Vector<arista> aristas = new Vector<>();
private String color;
private int tiempodestino;
private int tiempofinal;


public node(Object i) {
	setinfo(i);
}

public void setarista(arista a){
	aristas.add(a);
}

public String getcolor() {
	return color;
}

public void setcolor(String color) {
	this.color = color;
}

public Object getinfo() {
	return info;
}

public void setinfo(Object info) {
	this.info = info;
}

public int gettiempodestino() {
	return tiempodestino;
}

public Vector<arista> getaristas(){
	return aristas;
}

public void settiempodestino(int tiempodestino) {
	this.tiempodestino = tiempodestino;
}
public int gettiempofinal() {
	return tiempofinal;
}

public void settiempofinal(int tiempofinal) {
	this.tiempofinal = tiempofinal;
}
}
