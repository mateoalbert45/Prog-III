package P3_EJ2;

import java.util.Vector;

public class graph {
Vector<node>nodos= new Vector<>();


public void setnodo(node a){
	nodos.add(a);
}


public void dfs() {
	for(int i =0;i<nodos.size();i++) {
		nodos.elementAt(i).setcolor("blanco");
	}
	int tiempo=0;
	for(int i =0;i<nodos.size();i++) {
		node n=nodos.elementAt(i);
		if(n.getcolor().equals("blanco")) {
			dfs_visit(n,tiempo);
		}
	}
}

public int dfs_visit(node n,int t) {
	n.setcolor("amarillo");
	int tiempo = t+1;
	int numero = t+1;
	n.settiempodestino(tiempo);
	for(int i=0;i<n.getaristas().size();i++) {
		node aux=n.getaristas().elementAt(i).getdestination();
		if(aux.getcolor().equals("blanco")) {
				 tiempo = dfs_visit(aux,tiempo);
		}
	}
	n.setcolor("negro");
	System.out.println(n.getinfo());
	tiempo++;
	n.settiempofinal(tiempo);
	System.out.println("--- " + n.gettiempodestino());
	System.out.println("--- "+n.gettiempofinal());
	return tiempo;
}
}
