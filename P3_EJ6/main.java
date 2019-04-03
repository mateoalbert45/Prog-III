package P3_EJ6;

public class main {

	public static void main(String[] args) {
Node a = new Node(5);
Node b = new Node(8);
binarytree z = new binarytree();
z.add(8);
z.add(4);
System.out.println(z.getroot().getvalue());
System.out.println(z.haselem(4));
	}

}
