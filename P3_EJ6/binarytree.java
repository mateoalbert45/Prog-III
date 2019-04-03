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
 
    if (value < current.value) {
        current.left = addRecursive(current.left, value);
    } else if (value > current.value) {
        current.right = addRecursive(current.right, value);
    } else {
        // value already exists
        return current;
    }
 
    return current;
}

public boolean haselem(int value){
	return search(root, value);

}


private boolean search(Node current, int value){ 
    if(current.value == value){
    	return true;
    }else{
    	if (value < current.value) {
        	return search(current.left, value);
        } else if (value > current.value) {
        	return search(current.right, value);
        } else {
        	return false;
    }
	

    }
	//System.out.println("ne");

}

private int getheight(Node current, int value){ 
    int piso =1;

    	if (value < current.value) {
        	return search(current.left, value);
        } else if (value > current.value) {
        	return search(current.right, value);
        } else {
        	return false;
    
	

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
