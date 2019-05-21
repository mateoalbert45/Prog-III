package P5_EJ2;

import java.util.Vector;

public class laberinto {
	private int resultado = 0;
	private direccion[][] mat = new direccion[3][3];
	private Vector<direccion> direcciones = new Vector<>();
	private Vector<Integer> numeros_recorridos = new Vector<>();
	private int todoslosresultados = 0;

	public void setDireccion(direccion d) {
		direcciones.add(d);
	}

	public void resolver_tablero(int x_inicio, int y_inicio, int x_destino, int y_destino) {
		back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
	}

	public void back(direccion[][] mat, Vector<Integer> numeros_recorridos, int x_inicio, int y_inicio, int x_destino,
			int y_destino) {
		// System.out.println("hola");
		// es_solucion(mat);
		// System.out.println(fila);
		if (x_inicio == x_destino && y_inicio == y_destino) {
			todoslosresultados++;
			
			if (es_solucion(numeros_recorridos)) {
				System.out.println("hola");
			}

		} else {
			for (int i = 0; i < 3; i++) {

				Integer val = mat[x_inicio][y_inicio].getNumero();
				//System.out.println("x inicio" + x_inicio);
				//System.out.println(" y inicio"+y_inicio);
				if (mat[x_inicio][y_inicio].getNorte() == true) {
					// System.out.println(mat[x_inicio-1][y_inicio].getNumero());
					// System.out.println("hossssssla");
					//System.out.println("norte");

					if (!(numeros_recorridos.contains(mat[x_inicio - 1][y_inicio].getNumero()))) {
						numeros_recorridos.add(val);
						x_inicio--;
						back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
						numeros_recorridos.removeElement(val);

					}

				}
				if (mat[x_inicio][y_inicio].getSur() == true) {
					// System.out.println("hola");
					// System.out.println(mat[x_inicio+1][y_inicio].getNumero());

					if (!(numeros_recorridos.contains(mat[x_inicio + 1][y_inicio].getNumero()))) {
						numeros_recorridos.add(val);
						//System.out.println("sur");

						x_inicio++;
						back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
						numeros_recorridos.removeElement(val);
					}

				}
				 if (mat[x_inicio][y_inicio].getEste() == true) {
					// System.out.println(mat[x_inicio][y_inicio+1].getNumero());
					//System.out.println(x_inicio);
					//System.out.println(y_inicio);
					//System.out.println("este");

					if (!(numeros_recorridos.contains(mat[x_inicio][y_inicio + 1].getNumero()))) {
						numeros_recorridos.add(val);

						y_inicio++;
						back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
						numeros_recorridos.removeElement(val);
					}

				}
			 if (mat[x_inicio][y_inicio].getOeste() == true) {
					if (!(numeros_recorridos.contains(mat[x_inicio][y_inicio - 1].getNumero()))) {
						numeros_recorridos.add(val);
						//System.out.println("oeste");

						y_inicio--;
						back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
						numeros_recorridos.removeElement(val);

					}
				}
//					System.out.println("hola");

				// System.out.println(todoslosresultados);
				
//				numeros_recorridos.add(val);
//				back(mat, numeros_recorridos, x_inicio, y_inicio, x_destino, y_destino);
//				numeros_recorridos.removeElement(val);
				
			}
		}
	}

	public void cargar_matriz() {
		int total = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = direcciones.elementAt(total);
				total++;

			}
		}
	}

//	    	public void imprimir_matriz() {
//			for (int i = 0; i < mat.length; i++) {
//				for (int j = 0; j < mat[i].length; j++) {
//					System.out.println(mat[i][j].getNumero());
//				}
//			}
//		}

	public boolean es_solucion(Vector<Integer> numeros_recorridos) {
		int sum = 0;
		for (int i = 0; i < numeros_recorridos.size(); i++) {
			sum += numeros_recorridos.elementAt(i);
		}
		// System.out.println(sumf);
		if (resultado == 0) {
			resultado = sum;
			System.out.println(sum);

			return true;

		} else if (sum < resultado) {
			resultado = sum;
			System.out.println(sum);

			return true;

		}
		return false;

	}

	public int getTodoslosresultados() {
		return todoslosresultados;
	}

}
