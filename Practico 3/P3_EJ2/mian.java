package P3_EJ2;

public class mian {

	public static void main(String[] args) {
	
		node n1 = new node(1);
		node n2 = new node(2);
		node n3 = new node(3);
		node n4 = new node(4);
		node n5 = new node(5);
		arista a1 = new arista(n1,n2);
		arista a2 = new arista(n2,n3);
		arista a3 = new arista(n3,n1);
		arista a4 = new arista(n1,n3);
		n1.setarista(a1);
		n2.setarista(a2);
		n3.setarista(a3);

		graph g = new graph();
		g.setnodo(n1);
		g.setnodo(n2);
		g.setnodo(n3);
		g.dfs();

	}

}
