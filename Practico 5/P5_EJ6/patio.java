package P5_EJ6;

import java.util.Vector;

public class patio {
	private int cantidad_de_lugares_que_piso = 12;
	private int resultado = 0;
	private posicion[][] mat = new posicion[5][5];
	private Vector<posicion> posiciones = new Vector<>();
	private Vector<Integer> numeros_recorridos = new Vector<>();
	private int todoslosresultados = 0;

	public void setPosicion(posicion p) {
		posiciones.add(p);
	}

	public void resolver_juego_caballo(int x_inicio, int y_inicio, int x_destino, int y_destino) {
		Vector<posicion> posiciones_recorridas = new Vector<>();
		back(mat, posiciones_recorridas, x_inicio, y_inicio, x_destino, y_destino);
	}

	public void back(posicion[][] mat, Vector<posicion> posiciones_recorridas, int x_inicio, int y_inicio,
			int x_destino, int y_destino) {
		System.out.println("x inicio" + x_inicio);
		System.out.println(" y inicio" + y_inicio);
		// System.out.println("hola");
		// es_solucion(mat);
		// System.out.println(fila);
//		System.out.println("x inicio" + x_inicio);
//		System.out.println(" y inicio" + y_inicio);
//		System.out.println("x inicio" + x_inicio);
//		System.out.println(" y inicio" + y_inicio);
//		System.out.println("x inicio" + x_inicio);
//		System.out.println(" y inicio" + y_inicio);
		if (x_inicio == x_destino && y_inicio == y_destino && posiciones_recorridas.size() > 0) {
			todoslosresultados++;
			if (es_solucion(posiciones)) {
				System.out.println("hola");

			}

		} else {
			// posiciones_recorridas.add(mat[x_destino][y_destino]);
			for (int i = 0; i < 3; i++) {
				posicion actual = mat[x_inicio][y_inicio];
				posiciones_recorridas.add(actual);
				if (x_inicio - 1 >= 0 && mat[x_inicio - 1][y_inicio].getEstado() == "pisado"
						&& !(posiciones_recorridas.contains(mat[x_inicio - 1][y_inicio]))) { // NORTE

					posiciones_recorridas.add(actual);
					x_inicio--;
					back(mat, posiciones_recorridas, x_inicio, y_inicio, x_destino, y_destino);
					posiciones_recorridas.removeElement(mat[x_inicio + 1][y_inicio]);

				}

				else if (x_inicio + 1 <= 4 && mat[x_inicio + 1][y_inicio].getEstado() == "pisado"
						&& !(posiciones_recorridas.contains(mat[x_inicio + 1][y_inicio]))) { // SUR
//				System.out.println("x inicio" + x_inicio);
//				System.out.println(" y inicio" + y_inicio);
//				System.out.println(posiciones.contains(mat[x_inicio + 1][y_inicio]));
//				System.out.println(posiciones.size());

					posiciones_recorridas.add(actual);

					x_inicio++;
					back(mat, posiciones_recorridas, x_inicio, y_inicio, x_destino, y_destino);
					posiciones_recorridas.removeElement(mat[x_inicio - 1][y_inicio]);

				} else if (y_inicio + 1 <= 4 && mat[x_inicio][y_inicio + 1].getEstado() == "pisado"
						&& !(posiciones_recorridas.contains(mat[x_inicio][y_inicio + 1]))) {// ESTE
//				System.out.println("x inicio" + x_inicio);
//				System.out.println(" y inicio" + y_inicio);
					// System.out.println(posiciones_recorridas.contains(mat[x_inicio][y_inicio +
					// 1]));
					System.out.println("sdadsdsdasd");

					posiciones_recorridas.add(actual);

					y_inicio++;
					back(mat, posiciones_recorridas, x_inicio, y_inicio, x_destino, y_destino);
					posiciones_recorridas.removeElement(mat[x_inicio][y_inicio - 1]);

				} else if (y_inicio - 1 >= 0 && mat[x_inicio][y_inicio - 1].getEstado() == "pisado"
						&& !(posiciones_recorridas.contains(mat[x_inicio][y_inicio - 1]))) {// OESTE

					posiciones_recorridas.add(actual);

					y_inicio--;
					back(mat, posiciones_recorridas, x_inicio, y_inicio, x_destino, y_destino);
					posiciones_recorridas.removeElement(mat[x_inicio][y_inicio + 1]);

				}

			}
		}
	}

	public void cargar_matriz() {
		int total = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = posiciones.elementAt(total);
				total++;

			}
		}
	}

//	public void setear_lugar_pisado(posicion p) {
//		mat[0][1] = p;
//		mat[0][2] = p;
//		mat[0][3] = p;
//		mat[0][4] = p;
//		mat[1][1] = p;
//		mat[1][4] = p;
//		mat[2][1] = p;
//		mat[2][2] = p;
//		mat[2][4] = p;
//		mat[3][2] = p;
//		mat[3][3] = p;
//		mat[3][4] = p;
//
//	}

	public void imprimir_matriz() {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.println("fila " + i + "columna " + j + mat[i][j].getEstado());
			}
		}
	}

	public boolean es_solucion(Vector<posicion> posiciones) {
		int sum = 0;
		for (int i = 0; i < numeros_recorridos.size(); i++) {
			sum += numeros_recorridos.elementAt(i);
		}
		return false;

	}

	public int getTodoslosresultados() {
		return todoslosresultados;
	}
}
