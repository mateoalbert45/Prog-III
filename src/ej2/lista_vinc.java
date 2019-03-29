package ej2;
public class lista_vinc {
	protected Node first;
	private int size;
	
	public lista_vinc() {
	first = null;
	}
	public void insertFront(Object o) {
	Node tmp = new Node(o, null);
	tmp.setNext(first);
	first = tmp;
	size++;
	}
	public Object extractFront() {
		Node n = first;
		first = first.getNext();
		size--;
		return n;
		
	}
	
	public Node get_first() {
		return first;
		
	}
	
	public Object Get(int index) {
		Object info;
		Node n = first;
		for(int i=1; i<index; i++)
		n = n.getNext();
		info = n.getInfo();
		return info;
		
	}
	
	public void print(int a) {
	Node n = first;
	for(int i=1; i<a; i++){
		System.out.println(n.getInfo());
		n=n.getNext();
	}
		
	}
	
	 public boolean ordenado(Object a, Node b) {
		 if(b==null) {
			 return false;
		 }else {
			 if(a.equals(b.getInfo())) {
				 return true;
			 }else {
				 return ordenado(a,b.getNext());
			 }
			 
		 }		 
	 }
	public boolean isEmpty() {
		return first==null;
		
	}
	public int size () {
		return size;  
		
	}
}