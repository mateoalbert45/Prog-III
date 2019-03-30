package P2_ej3;
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
	
	 public void seleccion(Node a, Node b) {
			iterador i = new iterador(first);
		 Node menor= first;
		 Node tmp2= first.getNext();
		 Node aux;
		 while(i.hasNext()) {
			 

			 if((int)menor.getInfo()<(int)i.get()){
				i.next();
			 }
			 else if((int)menor.getInfo()>(int)i.get()) {
				 menor=i.getnodo();
				i.next();
			 }else {
				 i.next();
			 }
			
		 }
		 

		 aux = first;
		 first.setInfo(menor.getInfo());
		 first.setInfo(menor.getNext());
		 menor.setInfo(first.getInfo());
		 menor.setInfo(first.getNext());
		 
		 
		 System.out.println("---"+menor.getInfo()+"---");



	 }
	 
	 
	public boolean isEmpty() {
		return first==null;
		
	}
	
	 
	public void print() {
		iterador i = new iterador(first);
		System.out.println("--------");
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
	}
	
	public int size () {
		return size;  
		
	}
}