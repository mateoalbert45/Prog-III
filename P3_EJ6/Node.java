package P3_EJ6;

public class Node {
 int value;
 Node left;
 Node right;
 
 Node(int value){
	 this.value = value;
	 right= null;
	 left = null;
 }
 public int getvalue(){
	 return value;
 }
 public Node left(){
	 return left;
 }
 public Node right(){
	 return right;
 }
 
 
}
