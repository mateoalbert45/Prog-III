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
			for (int i = 0; i < 4; i++) {
				direccion pos = mat[x_inicio][y_inicio];
				Integer val = mat[x_inicio][y_inicio].getNumero();
				
				
				if(pos.getDireccionConNumero(i)){
					int x_inicio_aux =  establecer_x(x_inicio,i);
					int y_inicio_aux = establecer_y(y_inicio,i);
					if (!(numeros_recorridos.contains(mat[x_inicio_aux][y_inicio_aux].getNumero()))) {
						numeros_recorridos.add(val);
						back(mat, numeros_recorridos, x_inicio_aux, y_inicio_aux, x_destino, y_destino);
						numeros_recorridos.removeElement(val);

					}
				}
				
				
				
				
				//System.out.println("x inicio" + x_inicio);
				//System.out.println(" y inicio"+y_inicio);

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

	
	public int establecer_x(int x, int i){
		if(i == 0){
			return x-1;
		}
		else if(i== 1){
			return x +1;
			}
			else{
			return x;
		}
	}
	
	
	public int establecer_y(int y, int i){
		if(i == 2){
			return y+1;
		}
		else if(i== 3){
			return y-1;
			}
			else{
			return y;
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
