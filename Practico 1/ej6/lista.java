package ej6;



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
	
	public iterador getiterador(){
		return new iterador(first);
		
	}
	
	public void  insert(Object data) { 
        Node new_node = new Node(data, null); 

        if (first == null) { 
            first = new_node; 
        } 
        else { 
            Node last = first; 
            while (last.getNext() != null) { 
                last = last.getNext(); 
            } 
              last.setNext(new_node); 
        } 
        size++;
    } 
	
	
	public boolean pertenece(Object a) {
		iterador i1 = new iterador(first);
		while(i1.hasNext()){
			Object p = i1.next();
			if(p.equals(a)){
			 return true; 
				}		
			}

		return false;
		
	}
	
	public Node extractFront() {
		Node n = first;
		first = first.getNext();
		size--;
		return n;  
		}
	
	
	public void print() {
		Node n = first;
		while(n!=null) {
			System.out.print(n.getInfo().toString()+ " -> ");
			n = n.getNext();
		}
	}

    
	public boolean isEmpty() {	
		return first==null;  
		}
	
	
	
	public int size () {
		return size;  
		}


}
