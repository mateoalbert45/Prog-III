package P3_EJ6;

public class Node {
 private int value;
 private Node left;
 private Node right;
 
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
public void setvalue(int n) {
	this.value=n;
}
 public void setLeft(Node left) {
     this.left = left;
 }
 public void setRight(Node right) {
     this.right = right;
 }
 
}
