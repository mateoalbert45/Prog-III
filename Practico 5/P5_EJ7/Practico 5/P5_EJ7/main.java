package P5_EJ7;

public class main {

	public static void main(String[] args) {
		int[][] mat = new int[3][3];
		tablero t = new tablero();
		t.set_numero_posibles(1);
		t.set_numero_posibles(2);
		t.set_numero_posibles(3);
		t.set_numero_posibles(4);
		t.set_numero_posibles(5);
		t.set_numero_posibles(6);
		t.set_numero_posibles(7);
		t.set_numero_posibles(8);
		t.set_numero_posibles(9);


		t.resolver_tablero(mat);
		System.out.println(t.getndeah());
	}

}
