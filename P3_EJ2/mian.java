package P3_EJ2;

public class mian {

	public static void main(String[] args) {
	
		node n1 = new node(1);
		node n2 = new node(2);
		node n3 = new node(3);
		node n4 = new node(4);
		node n5 = new node(5);
		node n6 = new node(6);

		arista a1 = new arista(n1,n2);
		arista a2 = new arista(n2,n3);
		arista a3 = new arista(n1,n5);
		arista a4 = new arista(n5,n4);
		arista a5 = new arista(n4,n3);
		arista a6 = new arista(n5,n3);
		arista a7 = new arista(n1,n3);
		arista a8 = new arista(n5,n2);
		arista a9 = new arista(n3,n6);
		arista a10 = new arista(n6,n2);

		
		n1.setarista(a1);
		n2.setarista(a2);
		n1.setarista(a3);
		n5.setarista(a4);
		n4.setarista(a5);
		n5.setarista(a6);
		n1.setarista(a7);
		n5.setarista(a8);
		n3.setarista(a9);
		n6.setarista(a10);

		graph g = new graph();
		g.setnodo(n1);
		g.setnodo(n2);
		g.setnodo(n3);
		g.setnodo(n4);
		g.setnodo(n5);
		g.setnodo(n6);

		g.dfs(n1,n3);

	}

}
