package P5_EJ7;

import java.util.Vector;

public class tablero {
	int resultado = 86;
	int n = 3;
	int ndeah = 0;
	//int[][] mat = new int[3][2];
	Vector<Integer> numero_posibles = new Vector<>();
	
	
	public int getndeah() {
		return ndeah;
	}
	
	public void set_numero_posibles(int a) {
		numero_posibles.add(a);
	}
	
	
	public void resolver_tablero(int[][] mat) {
		back(mat,numero_posibles,0,0);
	}

	public void back(int[][] mat, Vector<Integer> numero_posibles, int fila, int columna) {
		//System.out.println("hola");
		//es_solucion(mat);
		//System.out.println(fila);
		if (fila == n - 1 && columna == n - 1) {
			ndeah++;
			if (es_solucion(mat)) {
				//System.out.println("hola");
		}

		} else {
			for (int i = 0; i < numero_posibles.size(); i++) {

				int val = numero_posibles.elementAt(i);
				numero_posibles.removeElement(val);
//				System.out.println("hola");
				//System.out.println(fila);
				//System.out.println(columna);

				mat[fila][columna] = val;
				fila++;
				if (fila == n) {
					fila = 0;
					columna++;
				}
				back(mat, numero_posibles, fila, columna);
				fila--;
				if (fila == -1) {
					fila = n - 1;
					columna--;
				}
					mat[fila][columna] = 0;
					numero_posibles.add(val);
				
			}
		}

	}
	
//	public void cargar_matriz() {
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[i].length; j++) {
//				mat[i][j] = i +2;
//			}
//		}
//	}
//
//	public void imprimir_matriz() {
//		for (int i = 0; i < mat.length; i++) {
//			for (int j = 0; j < mat[i].length; j++) {
//				System.out.println(mat[i][j]);
//			}
//		}
//	}
	
	public boolean es_solucion(int[][] mat) {
		int sumf = 0;
		for (int i = 0; i < mat.length; i++) {
			
			for (int j = 0; j < mat[i].length; j++) {
				sumf = sumf + mat[i][j];
			}
			
		}
		//System.out.println(sumf);
		int sum_total= sumf + sumar_columna(mat);

		if (sum_total == resultado) {
			//System.out.println(sum_total);

			return true;

		}
		return false;

	}
	
	
	public int sumar_columna(int[][] mat) {
		int sumc = 0;
		for (int i = 0; i <mat[0].length; i++) {
			
			for (int j = 0; j < mat.length; j++) {
				sumc = sumc + mat[j][i];
			}
			
		}
		//System.out.println(sumc);

		return sumc;

	}

}
