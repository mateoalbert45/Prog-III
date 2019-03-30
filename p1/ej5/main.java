package ej5;


public class main {

	public static void main(String[] args) {
		lista l1 = new lista();
		l1.insert(1);
		l1.insert(3);
		l1.insert(4);
		l1.insert(7);

		l1.insert(9);
		lista l2 = new lista();
		l2.insert(1);
		l2.insert(4);
		l2.insert(7);
		l2.insert(8);
		l2.insert(9);

		orden o = new orden();
		o.lista_ordenada(l1, l2);
		
	}

}
