package P3_EJ2;

import java.util.Vector;

public class node {
private Object info;
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
