package P5_EJ9;

import java.util.Vector;

public class tablero {
	int total =0;
	int[][] mat = new int[4][4];

	
	public void back(int[][] mat, Vector<Integer> numero_posibles, int fila, int columna) {
		//System.out.println("hola");
		//es_solucion(mat);
		//System.out.println(fila);
		if (mat[3][3] == 0) {
			total++;
			//if (es_solucion(mat)) {
				System.out.println("hola");
		//}

		} else {
			for (int i = 0; i < 15; i++) {

				int val = numero_posibles.elementAt(i);
				numero_posibles.removeElement(val);
//				System.out.println("hola");
				//System.out.println(fila);
				//System.out.println(columna);

				mat[fila][columna] = val;
				fila++;
				if (fila == mat[0].length) {
					fila = 0;
					columna++;
				}
				back(mat, numero_posibles, fila, columna);
				fila--;
				if (fila == -1) {
					fila = mat[0].length - 1;
					columna--;
				}
					mat[fila][columna] = 0;
					numero_posibles.add(val);
				
			}
		}

	}
	
	public void cargar_matriz(int fila, int columna) {
		int total = 1;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = total;
				total++;
			}
		}
		
		mat[fila][columna] = 0;
		
	}

}
