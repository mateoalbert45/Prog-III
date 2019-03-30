package ej5;

public class Node {
	private int info;
	private Node next;

	public Node() {
	info = 0;
	next = null;
	}
	public Node(int o, Node n) {
	setInfo(o);
	setNext(n);
	}
	public void setInfo(int o) {
	info = o;
	}
	public void setNext(Node n) {
	next = n;
	}
	public int getInfo() {
	return info;
	}
	public Node getNext() {
	return next;
	}
}
