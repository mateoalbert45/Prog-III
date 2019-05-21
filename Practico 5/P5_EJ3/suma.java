package P5_EJ3;

import java.util.Vector;

public class suma {
	int m = 13;
	int total = 0;
	Vector<Integer> numeros = new Vector<>();

	public void setnumero(int i) {
		numeros.add(i);
	}

	public void encontrar_numero() {
		Vector<Integer> numeros_sumados = new Vector<>();
		back(numeros, numeros_sumados);
	}

	public void back(Vector<Integer> numeros, Vector<Integer> numeros_sumados) {
		//System.out.println("dasdasd");
		if (numeros_sumados.size() == numeros.size()) {
			total++;
			if (es_solucion(numeros_sumados)) {
				System.out.println("hola");
			}
		} else {
			for (int i = 0; i < numeros.size(); i++) {
				Integer val = numeros.elementAt(i);
				numeros_sumados.add(val);
				back(numeros, numeros_sumados);
				numeros_sumados.removeElement(val);
			}
		}
	}

	public boolean es_solucion(Vector<Integer> numeros_sumados) {
		int resultado = 0;
		for (int i = 0; i < numeros_sumados.size(); i++) {
			resultado += numeros_sumados.elementAt(i);
		}

		return resultado == m;
	}

	
	public int gettotal() {
		return total;
	}
}
