package ej5;



public class lista {
	protected Node first;
	private int size;
	public lista() {
	first = null;
	}
	public void insertFront(int n) {
	Node tmp = new Node(n, null);
	tmp.setNext(first);
	first = tmp;
	size++;
	}
	
	
	public void recorrer(){
		iterador i1 = new iterador(first);
		while(i1.hasNext()){
			Node p = i1.next();
			System.out.println(p.getInfo());
		}
	}
	
	
	public void  insert(int data) 
    { 
        // Create a new node with given data 
        Node new_node = new Node(data, null); 
  
        // If the Linked List is empty, 
        // then make the new node as head 
        if (first == null) { 
            first = new_node; 
        } 
        else { 
            // Else traverse till the last node 
            // and insert the new_node there 
            Node last = first; 
            while (last.getNext() != null) { 
                last = last.getNext(); 
            } 
  
            // Insert the new_node at last node 
            last.setNext(new_node); 
        } 
size++;
    } 
	
	public Node extractFront() {
		Node n = first;
		first = first.getNext();
		size--;
		return n;  
		}
	
	public void maximo () {
		int n=0;
		int pos=1;
		int aux=1;
		iterador i1 = new iterador(first);
		while(i1.hasNext()){
			
			Node p = i1.next();
			if(n==0) {
			n=p.getInfo();	
			}
			if(n<p.getInfo()){
				n=p.getInfo();
				pos = aux;
			}
			aux++;
		}
		//pos = poscicion(n);
		System.out.println("El numero mas grande de la listas es " + n + " en las posicion " + pos);
		}
	
	public void print() {
		Node n = first;
		while(n!=null) {
			System.out.print(n.getInfo()+ " -> ");
			n = n.getNext();
		}
	}

    public void ordenar() {
		for (int i = 0; i < size; i++ ) {

                Node currentNode = first;
                Node next = first.getNext();
                for (int j = 0; j < size - 1; j++) {

                    if (currentNode.getInfo() > next.getInfo()) {
                        int temp = currentNode.getInfo();
                        currentNode.setInfo(next.getInfo());
                        next.setInfo(temp);

                    } 
                    currentNode = next;
                    next = next.getNext();  

                } 
		}
        
            this.print();
    }

    
	public boolean isEmpty() {
		
		return first==null;  
		}
	
	
	
	public int size () {
		return size;  
		}


}
