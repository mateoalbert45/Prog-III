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
		if (x_inicio == x_destino && y_inicio == y_destino && posiciones_recorridas.size() > 0) {
			todoslosresultados++;
			if (es_solucion(posiciones)) {
				System.out.println("hola");

			}

		} else {
			for (int i = 0; i < 4; i++) {

				int x_inicio_aux = establecer_x(x_inicio, i);
				int y_inicio_aux = establecer_y(y_inicio, i);

				if (corroborar_movimiento(x_inicio_aux, y_inicio_aux, mat)) {
					posicion actual = mat[x_inicio_aux][y_inicio_aux];

					if (mat[x_inicio_aux][y_inicio_aux].getEstado() == "pisado")
						if (!(posiciones_recorridas.contains(mat[x_inicio_aux][y_inicio_aux]))) {

							posiciones_recorridas.add(actual);
							back(mat, posiciones_recorridas, x_inicio_aux, y_inicio_aux, x_destino, y_destino);
							numeros_recorridos.removeElement(actual);

						}
				}

			}
		}
	}

	public int establecer_x(int x, int i) {
		if (i == 0) {
			return x - 1;
		} else if (i == 1) {
			return x + 1;
		} else {
			return x;
		}
	}

	public int establecer_y(int y, int i) {
		if (i == 2) {
			return y + 1;
		} else if (i == 3) {
			return y - 1;
		} else {
			return y;
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

	public boolean corroborar_movimiento(int x, int y, posicion[][] mat) {
		if (x >= 0 && x < mat.length) {
			if (y >= 0 && y < mat[0].length) {
				return true;
			}
		}
		return false;
	}

	// public void setear_lugar_pisado(posicion p) {
	// mat[0][1] = p;
	// mat[0][2] = p;
	// mat[0][3] = p;
	// mat[0][4] = p;
	// mat[1][1] = p;
	// mat[1][4] = p;
	// mat[2][1] = p;
	// mat[2][2] = p;
	// mat[2][4] = p;
	// mat[3][2] = p;
	// mat[3][3] = p;
	// mat[3][4] = p;
	//
	// }

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
