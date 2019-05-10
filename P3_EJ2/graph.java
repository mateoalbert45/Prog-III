package P3_EJ2;

import java.util.Vector;

public class graph {
	Vector<node> nodos = new Vector<>();

	public void setnodo(node a) {
		nodos.add(a);
	}

	public void dfs(node origen, node objetivo) {
		for (int i = 0; i < nodos.size(); i++) {
			nodos.elementAt(i).setcolor("blanco");
		}
		Vector<node> nodos_visitados = new Vector<>();
		dfs_visit(origen, objetivo, nodos_visitados);
	}

	public int dfs_visit(node n, node objetivo, Vector<node> vec) {
		int a = 0;
		
		for (int i = 0; i < n.getaristas().size(); i++) {
			node aux = n.getaristas().elementAt(i).getdestination();
			vec.add(n);
			
			if (aux.equals(objetivo)) {
				vec.add(aux);
				imprimir_vector(vec);
				System.out.println("Camino encontrado \n");
				vec.remove(aux);

			} else if (aux.getcolor().equals("blanco")) {
				aux.setcolor("amarillo");
				dfs_visit(aux, objetivo, vec);
				aux.setcolor("blanco");
			}
			vec.remove(n);
		}
		return a;
	}

	public void imprimir_vector(Vector<node> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.elementAt(i).getinfo());

		}
	}
}
