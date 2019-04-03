package ej6;

import java.util.Iterator;

public class iterador implements Iterator<Object>  {
	private Node n;
	public iterador(Node n) {
		this.n = n;
	}
	
	public boolean hasNext() {
		return n != null;
	}

	public Object next() {
		Object tmp;
		tmp = n.getInfo();
		n = n.getNext();
		return tmp;
	}
	
	public Node get() {
		return n;
	}
	
}
