package P3_EJ6;

import java.util.LinkedList;
import java.util.Vector;

public class binarytree {
Node root;


public void insert(int value) {
    root = agregar(root, value);
}


private Node agregar(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.getvalue()) {
        current.setLeft(agregar(current.left(), value));
    } else if (value > current.getvalue()) {

        current.setRight(agregar(current.right(), value));
    } else {
        return current;
    }
 
    return current;
}

public boolean haselem(int value){
	return search(root, value);

}

public Node delete(int value){
	return searchdelete(root, value);

}


private Node searchdelete(Node current, int value){ 
    	if (value < current.getvalue()) {
    		current.setLeft(searchdelete(current.left(), value));
        } else if (value > current.getvalue()) {
    		current.setRight(searchdelete(current.right(), value));
        } else {
        	if(current.left()==null && current.right()== null) {
        		
        		return null;
        	}
        	else if(current.left()==null){

        		return current.right();
        	}
        	else if(current.right()==null){

        		return current.left();
        	}else{
                    current.setvalue(current.right().getvalue()); 
            		current.setRight(searchdelete(current.right(),current.right().getvalue()));
        		
        	}
    }
		return current;
}
private boolean search(Node current, int value){ 
    if(current.getvalue() == value){
    	return true;
    }else{
    	if (value < current.getvalue()) {
        	return search(current.left(), value);
        } else if (value > current.getvalue()) {
        	return search(current.right(), value);
        } else {
        	return false;
    }
	

    }
	//System.out.println("ne");

}


public int getheight(){
	return searchheight(root);
}

private int searchheight(Node current){ 
	if(current==null) {
		return 0;
	}else if(current.left()==null && current.right()==null) {
			return 1;
		}else {
			int l=searchheight(current.left()); 
			int r=searchheight(current.right()); 
			return 1+Math.max(l, r);
	 }


	
	
	
}

public LinkedList<Node> getfrontera(){
	return searchfrontera(root);
}

private LinkedList<Node> searchfrontera(Node current){ 
	LinkedList<Node> l= new LinkedList<Node>();
	if(current.left()==null && current.right()== null) {
		System.out.println(current.getvalue());
		l.add(current);
		return l;
	}
	else {
     if(current.left()==null){
    		return searchfrontera(current.right());
    	}
    	else if(current.right()==null){
    		return searchfrontera(current.left());
    	}
    	else {
    		LinkedList<Node> a1= searchfrontera(current.right());
    		LinkedList<Node> a2= searchfrontera(current.left());
    		l.addAll(a1);
    		l.addAll(a2); 
    		return l;
    	}
}
}





public Node getroot(){
	return root;
}

public boolean isempty(){
	return root==null;
}
}
