package P3_EJ2;

public class arista {
private node origin;
private node destination;

public arista(node o,node d) {
	setorigin(o);
	setdestination(d);
}

public node getorigin() {
	return origin;
}

public void setorigin(node origin) {
	this.origin = origin;
}

public node getdestination() {
	return destination;
}

public void setdestination(node destination) {
	this.destination = destination;
}




}
