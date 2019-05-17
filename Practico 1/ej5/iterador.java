package ej5;

public class iterador {
	private Node n;
	public iterador(Node n) {
		this.n = n;
	}
	
	public boolean hasNext() {
		return n != null;
	}

	public Node next() {
		Node tmp;
		tmp = n;
		n = n.getNext();
		return tmp;
	}
	
	public Node get() {
		return n;
	}
	
}
