package P3_EJ6;

public class binarytree {
Node root;


public void add(int value) {
    root = addRecursive(root, value);
}


private Node addRecursive(Node current, int value) {
    if (current == null) {
        return new Node(value);
    }
 
    if (value < current.getvalue()) {
        current.setLeft(addRecursive(current.left(), value));
    } else if (value > current.getvalue()) {

        current.setRight(addRecursive(current.right(), value));
    } else {
        // value already exists
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





public Node getroot(){
	return root;
}

public boolean isempty(){
	return root==null;
}
}
